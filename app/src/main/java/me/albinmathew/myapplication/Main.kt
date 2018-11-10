package me.albinmathew.myapplication

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val add = calculate(4, 5, ::add)
            val diff = calculate(4, 5, ::diff)
            val multiply = calculate(4, 5, ::multiply)
            val divide = calculate(4, 5) { a, b -> a divide b }
            println("add $add, diff $diff, mult $multiply, divide $divide")
        }
    }
}

fun calculate(x: Int, y: Int, operator: (Int, Int) -> Any): Any {
    return operator(x, y)
}

fun add(a: Int, b: Int): Int = a + b

fun diff(a: Int, b: Int): Int = a - b

fun multiply(a: Int, b: Int) = a * b

infix fun Int.divide(a: Int): Double = this / a.toDouble()

