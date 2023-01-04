package com.hanbyeol.test.ghostLeg

class Line {
    val reward: Int // 보상
    val isHorizontal: Boolean // 가로줄인지 세로줄인지 여부

    constructor(reward: Int, isHorizontal: Boolean) {
        this.reward = reward
        this.isHorizontal = isHorizontal
    }
}