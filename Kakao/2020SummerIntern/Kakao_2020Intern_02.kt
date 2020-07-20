//2번

//문제 설명
//IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
//이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
//해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며, 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
//단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다. 즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다. 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합이 가능합니다.
//만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며, 우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
//
//예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
//
//"100-200*300-500+20"
//
//일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
//대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
//수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
//반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
//
//참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때, 우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.
//
//[제한사항]
//expression은 길이가 3 이상 100 이하인 문자열입니다.
//expression은 공백문자, 괄호문자 없이 오로지 숫자와 3가지의 연산자(+, -, *) 만으로 이루어진 올바른 중위표기법(연산의 두 대상 사이에 연산기호를 사용하는 방식)으로 표현된 연산식입니다. 잘못된 연산식은 입력으로 주어지지 않습니다.
//즉, "402+-561*"처럼 잘못된 수식은 올바른 중위표기법이 아니므로 주어지지 않습니다.
//expression의 피연산자(operand)는 0 이상 999 이하의 숫자입니다.
//즉, "100-2145*458+12"처럼 999를 초과하는 피연산자가 포함된 수식은 입력으로 주어지지 않습니다.
//"-56+100"처럼 피연산자가 음수인 수식도 입력으로 주어지지 않습니다.
//expression은 적어도 1개 이상의 연산자를 포함하고 있습니다.
//연산자 우선순위를 어떻게 적용하더라도, expression의 중간 계산값과 최종 결괏값은 절댓값이 263 - 1 이하가 되도록 입력이 주어집니다.
//같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높습니다.
//입출력 예
//expression	result
//"100-200*300-500+20"	60420
//"50*6-3*2"	300
//입출력 예에 대한 설명
//입출력 예 #1
//* > + > - 로 연산자 우선순위를 정했을 때, 가장 큰 절댓값을 얻을 수 있습니다.
//연산 순서는 아래와 같습니다.
//100-200*300-500+20
//= 100-(200*300)-500+20
//= 100-60000-(500+20)
//= (100-60000)-520
//= (-59900-520)
//= -60420
//따라서, 우승 시 받을 수 있는 상금은 |-60420| = 60420 입니다.
//
//입출력 예 #2
//- > * 로 연산자 우선순위를 정했을 때, 가장 큰 절댓값을 얻을 수 있습니다.
//연산 순서는 아래와 같습니다.(expression에서 + 연산자는 나타나지 않았으므로, 고려할 필요가 없습니다.)
//50*6-3*2
//= 50*(6-3)*2
//= (50*3)*2
//= 150*2
//= 300
//따라서, 우승 시 받을 수 있는 상금은 300 입니다.



package kakao

import java.util.regex.Pattern

fun main() {


    var case1 = "100-200*300-500+20"
    val case2 = "50*6-3*2"
    val case3 = "200*#10-#8-30"

    val clazz = Kakao_2020Intern_02()

    println(clazz.solution(case3))
}


val threeOperatorSet = listOf(
    listOf("+", "-", "*"),
    listOf("+", "*", "-"),
    listOf("-", "+", "*"),
    listOf("-", "*", "+"),
    listOf("*", "+", "-"),
    listOf("*", "-", "+")
)
val operatorSet = arrayOf("+", "-", "*")

class Kakao_2020Intern_02 {

    fun solution(expression: String): Long {
        var answer = 0L

        val extractOperators = extractOperators(expression)

        if (extractOperators.size == 3) {
            for (operators in threeOperatorSet) {
                val result = calculateString(expression, operators)
                if (answer < result) {
                    answer = result
                }
            }
            return answer
        }
        if (extractOperators.size == 2) {
            var calculateResult = calculateString(expression, extractOperators)
            if (answer < calculateResult) {
                answer = calculateResult
            }
            calculateResult = calculateString(expression, extractOperators.reversed())
            if (answer < calculateResult) {
                answer = calculateResult
            }
            return answer
        }
        return calculateString(expression, extractOperators)
    }

    private fun calculateString(expression: String, operators: List<String>): Long {
        var result = expression
        for (operator in operators) {
            result = calculateString(result, operator)
        }
        println("result : $result")
        println()
        return result.replace("#", "").toLong()
    }

    private fun calculateString(expression: String, operator: String): String {

        val pattern = Pattern.compile("#?(\\d)+\\$operator#?(\\d)+")
        var calculatedExpression = expression

        while (true) {
            val matcher = pattern.matcher(calculatedExpression)
            if (!matcher.find()) break

            println("string : $calculatedExpression")
            val matchString = matcher.group(0).split(operator)
            val left = matchString[0].replace("#", "-").toLong()
            val right = matchString[1].replace("#", "-").toLong()
            println("left : $left // right : $right")
            val result = calculate(left, right, operator)
            val resultString = if (result < 0) "#${-result}" else "$result"

            calculatedExpression = calculatedExpression.replace(matcher.group(0), resultString)
        }
        println(calculatedExpression)
        return calculatedExpression
    }

    private fun calculate(left: Long, right: Long, operator: String): Long = when (operator) {
        "*" -> left * right
        "-" -> left - right
        "+" -> left + right
        else -> throw RuntimeException()
    }


    private fun extractOperators(expression: String): List<String> {
        val operators = ArrayList<String>()
        for (operator in operatorSet) {
            if (expression.contains(operator)) {
                operators.add(operator)
            }
        }
        return operators
    }
}

