package baekjoon

// 이중 우선순위 큐
//문제
//이중 우선순위 큐(dual priority queue)는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조이다. 전형적인 큐와의 차이점은 데이터를 삭제할 때 연산(operation) 명령에 따라 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 점이다. 이중 우선순위 큐를 위해선 두 가지 연산이 사용되는데, 하나는 데이터를 삽입하는 연산이고 다른 하나는 데이터를 삭제하는 연산이다. 데이터를 삭제하는 연산은 또 두 가지로 구분되는데 하나는 우선순위가 가장 높은 것을 삭제하기 위한 것이고 다른 하나는 우선순위가 가장 낮은 것을 삭제하기 위한 것이다.
//
//정수만 저장하는 이중 우선순위 큐 Q가 있다고 가정하자. Q에 저장된 각 정수의 값 자체를 우선순위라고 간주하자.
//
//Q에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성하라.
//
//입력
//입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)가 주어진다. 이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어진다. ‘I n’은 정수 n을 Q에 삽입하는 연산을 의미한다. 동일한 정수가 삽입될 수 있음을 참고하기 바란다. ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며, ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미한다. 최댓값(최솟값)을 삭제하는 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제됨을 유념하기 바란다.
//
//만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다. Q에 저장될 모든 정수는 32-비트 정수이다.
//
//출력
//출력은 표준출력을 사용한다. 각 테스트 데이터에 대해, 모든 연산을 처리한 후 Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라. 두 값은 한 줄에 출력하되 하나의 공백으로 구분하라. 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.
//
//예제 입력 1
//2
//7
//I 16
//I -5643
//D -1
//D 1
//D 1
//I 123
//D -1
//9
//I -45
//I 653
//D 1
//I -642
//I 45
//I 97
//D 1
//D -1
//I 333
//예제 출력 1
//EMPTY
//333 -45

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BOJ_7662().solution()
}

class BOJ_7662 {

    fun solution() {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val testCount = bufferedReader.readLine().toInt()
        val stringBuilder = StringBuilder()
        repeat(testCount) {
            val priorityQueue = DoublePriorityQueue()
            val inputCount = bufferedReader.readLine().toInt()
            repeat(inputCount) {
                val input = bufferedReader.readLine().split(" ")
                val order = input[0]
                val value = input[1].toLong()
                if (order == "I") {
                    priorityQueue.add(Number(it, value))
                }
                if (order == "D") {
                    if (value == -1L) {
                        priorityQueue.deleteMin()
                    }
                    if (value == 1L) {
                        priorityQueue.deleteMax()
                    }
                }
            }
            if (priorityQueue.isEmpty()) stringBuilder.append("EMPTY\n")
            else stringBuilder.append("${priorityQueue.peekMax().value} ${priorityQueue.peekMin().value}\n")
        }
        print(stringBuilder.toString())
    }

    class DoublePriorityQueue {
        private val maxPriorityQueue = PriorityQueue<Number>(Collections.reverseOrder())
        private val minPriorityQueue = PriorityQueue<Number>()
        private val memory = HashMap<Number, Boolean>()

        fun add(element: Number) {
            maxPriorityQueue.add(element)
            minPriorityQueue.add(element)
        }

        fun deleteMin() {
            if (minPriorityQueue.isEmpty()) return
            val min = minPriorityQueue.peek()
            if (memory[min] != true) {
                memory[min] = true
                minPriorityQueue.poll()
            }
            arrangeHeap()
        }

        fun deleteMax() {
            if (maxPriorityQueue.isEmpty()) return
            val max = maxPriorityQueue.peek()
            if (memory[max] != true) {
                memory[max] = true
                maxPriorityQueue.poll()
            }
            arrangeHeap()
        }

        private fun arrangeHeap() {
            listOf(minPriorityQueue, maxPriorityQueue).forEach {
                while (it.isNotEmpty()) {
                    if (memory[it.peek()!!] == true) it.poll()
                    else break
                }
            }
        }

        fun peekMin(): Number {
            return minPriorityQueue.peek()
        }

        fun peekMax(): Number {
            return maxPriorityQueue.peek()
        }

        fun isEmpty(): Boolean {
            return minPriorityQueue.isEmpty()
        }
    }

    data class Number(
        val id: Int,
        val value: Long
    ) : Comparable<Number> {
        override fun compareTo(other: Number): Int {
            return if (this.value > other.value) 1
            else -1
        }
    }
}
