package com.hanbyeol.test.ghostLeg

class Node {
    val verticalLine: Line // 세로줄
    val horizontalLine: Line? // 가로줄. 선택하지 않은 세로줄은 null값을 가짐
    val nextNode: Node? // 연결된 다음 Node

    constructor(verticalLine: Line, horizontalLine: Line? = null, nextNode: Node? = null) {
        this.verticalLine = verticalLine
        this.horizontalLine = horizontalLine
        this.nextNode = nextNode
    }
}