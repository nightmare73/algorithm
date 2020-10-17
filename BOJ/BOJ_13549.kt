package baekjoon

// 숨바꼭질 3
//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//예제 입력 1
//5 17
//예제 출력 1
//2
//힌트
//수빈이가 5-10-9-18-17 순으로 가면 2초만에 동생을 찾을 수 있다.

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BOJ_13549().solution()
}

class BOJ_13549 {
    fun solution() {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val (startPosition, targetPosition) = bufferedReader.readLine().split(" ").map(String::toInt)
        val isVisited = BooleanArray(100_001) { false }
        val queue = LinkedList(listOf(Distance(startPosition)))
        isVisited[startPosition] = true
        while (queue.isNotEmpty()) {
            val distance = queue.poll()
            if (distance.value == targetPosition) {
                println(distance.count)
                break
            }
            val zeroCount = distance.value * 2
            if (zeroCount in 0..100_000 && !isVisited[zeroCount]) {
                isVisited[zeroCount] = true
                queue.add(Distance(zeroCount, distance.count))
            }
            listOf(distance.value - 1, distance.value + 1).forEach {
                if (it in 0..100_000 && !isVisited[it]) {
                    isVisited[it] = true
                    queue.add(Distance(it, distance.count + 1))
                }
            }
        }
    }

    data class Distance(
        val value: Int,
        val count: Int = 0
    )
}
