package baekjoon

// 좌표 정렬하기

//문제
//2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
//
//출력
//첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
//
//예제 입력 1
//5
//0 4
//1 2
//1 -1
//2 2
//3 3
//예제 출력 1
//1 -1
//1 2
//2 2
//3 3
//0 4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BOJ_11651.start()
}

class BOJ_11651 {

    companion object {
        fun start() {
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val count = bufferedReader.readLine().toInt()
            val coords = MutableList(count) {
                val input = bufferedReader.readLine().split(" ")
                Coord(input[0].toInt(), input[1].toInt())
            }
            println(coords.sorted().joinToString("\n"))
        }

        class Coord(val x: Int, val y: Int) : Comparable<Coord> {
            override fun compareTo(other: Coord): Int {
                return if (this.y == other.y) {
                    this.x.compareTo(other.x)
                } else {
                    this.y.compareTo(other.y)
                }
            }

            override fun toString(): String {
                return "$x $y"
            }
        }
    }
}
