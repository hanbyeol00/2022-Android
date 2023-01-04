package com.hanbyeol.test.ghostLeg

class LadderGame {
    val nodes: List<Node>

    constructor(nodes: List<Node>) {
        this.nodes = nodes
    }

    fun play(selectedVerticalLine: Line): Int {
        // 선택한 세로줄을 가지고 있는 Node를 찾음
        val currentNode = nodes.find { it.verticalLine == selectedVerticalLine }
            ?: throw IllegalArgumentException("Invalid vertical line")

        // 가로줄을 타고 다음 Node로 이동
        var nextNode = currentNode.nextNode
        var reward = currentNode.verticalLine.reward

        while (nextNode != null) {
            reward += nextNode.horizontalLine!!.reward // 가로줄을 타면서 얻은 보상을 추가
            nextNode = nextNode.nextNode // 다음 Node로 이동
        }

        return reward
    }
}