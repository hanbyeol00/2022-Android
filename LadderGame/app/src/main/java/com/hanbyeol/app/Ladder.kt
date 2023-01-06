package com.hanbyeol.app

import android.graphics.Point
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class Ladder: Serializable {
    val MAX_HEIGHT = 20  // 최대 높이
    val HEIGHT_RANGE = 7.5f // 세로줄 사이의 최대 간격
    val MARGIN_HEIGHT = (MAX_HEIGHT - HEIGHT_RANGE * 2 - 1).toInt() / 2 // 최상단과 최하단의 최소 간격

    var pointGrid: ArrayList<ArrayList<Int>> = arrayListOf() // 세로줄과 가로줄을 저장하는 2차원 배열


    /**
     * 시작 위치에서 사다리를 오른 순서로 가는 결로를 Point 객체의 리스트로 반환
     *
     * contains() 전달받은 값에 ()안의 값이 존재하는지 여부 확인인     */
    fun getPoints(startPosition: Int): ArrayList<Point> {
        val firstPoint = Point(startPosition, pointGrid[startPosition][0])
        val points = arrayListOf<Point>(Point(startPosition, pointGrid[startPosition][0]))

        var currentPoint = firstPoint
        var isFindX = true

        while (true) {
            val xIndex = currentPoint.x
            val yIndex = currentPoint.y
            val yValue = pointGrid[xIndex][yIndex]

            if (yValue == MAX_HEIGHT) break

            if (isFindX) {
                currentPoint = Point(xIndex, yIndex + 1)
            } else {
                val nextXIndex = if (xIndex >= 1 && pointGrid[xIndex - 1].contains(yValue) && (xIndex - 1) % 2 === yValue % 2) xIndex - 1 else xIndex + 1
                val newYIndex = pointGrid[nextXIndex].indexOf(yValue)
                currentPoint = Point(nextXIndex, newYIndex)
            }
            points.add(Point(currentPoint.x, pointGrid[currentPoint.x][currentPoint.y]))
            isFindX = !isFindX
        }

        return points
    }

    /**
     * 세로줄을 Line 객체의 리스트로 반환
     */
    public fun getVerticalLines(): ArrayList<Line> {
        val lines = arrayListOf<Line>()
        for (i in 0 until pointGrid.size) {
            lines.add(Line(Point(i, 0), Point(i, MAX_HEIGHT)))
        }
        return lines
    }

    /**
     * 가로줄을 Line 객체의 리스트로 반환
     */
    public fun getHorizontalLines(): ArrayList<Line> {
        val lines = arrayListOf<Line>()

        for (i in 0 until pointGrid.size - 1) {
            val verticalLine = pointGrid[i]

            for (j in 1 until verticalLine.size - 1) {
                val y = verticalLine[j]
                //나머지로 비교
                if (y % 2 !== i % 2) continue

                lines.add(
                    Line(
                        Point(i, y),
                        Point(i + 1, y)
                    )
                )
            }
        }

        return lines
    }

    /**
     * pointGrid(세로줄 가로줄 저장하는 2차원 배열) 을 초기화 하고 새로운 사다리를 생성
     * 인자로 주어진 count 값에 따라 세로줄 가로줄 개수가 결졍
     */
    public fun initializeLadder(count: Int) {
        pointGrid.clear()
        initializeVerticalLines(count)
        initializeHorizontalLines(count)
    }

    /**
     * 세로줄을 초기화
     */
    fun initializeVerticalLines(count: Int) {
        for (i in 0 until count) {
            val newLine = arrayListOf(0, MAX_HEIGHT)
            pointGrid.add(newLine)
        }
    }

    /**
     * 가로줄을 생성하고 PointGrid에 추가
     */
    fun initializeHorizontalLines(count: Int) {
        var ladderCount = getLadderCount(count)

        // 일단 1개씩은 다 넣어줌
        for (i in 0 until count - 1) {
            val rest = i % 2
            val y = (Math.random() * HEIGHT_RANGE).toInt() * 2 + MARGIN_HEIGHT + rest
            pointGrid[i].add(y)
            pointGrid[i + 1].add(y)
            ladderCount--

        }

        while (ladderCount > 0) {
            val idx = (Math.random() * (count - 1)).toInt()

            if (idx === count - 1) continue

            val rest = idx % 2
            val y = (Math.random() * HEIGHT_RANGE).toInt() * 2 + MARGIN_HEIGHT + rest
            if (pointGrid[idx].contains(y)) continue

            pointGrid[idx].add(y)
            pointGrid[idx + 1].add(y)

            ladderCount--
        }

        for (i in 0 until count) {
            pointGrid[i].sort()
        }
    }

    private val min = 6
    private val max = 11

    /**
     * 생성할 가로줄의 개수를 계산
     */
    fun getLadderCount(count: Int): Int {
        val random = Random()
        val num = (random.nextInt(2)) + random.nextInt(3)
        return Math.max(count * num + (random.nextInt(4)), 0 )
        //return Math.max(count * 2 - 3, 6)
        //주어진 수식 중 가장 큰 결과 값을 반환
    }
}