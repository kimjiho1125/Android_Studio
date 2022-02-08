package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {
    val calculator1 = Calculator()
    calculator1.plus(4, 5)
    calculator1.minus(4, 5)
    calculator1.multiply(4, 5)
    calculator1.divide(4, 5)
    println()

    val calculator2 = Calculator2()
    println(calculator2.plus(1,2,3,4,5))
    println(calculator2.minus(10,1,2,3,))
    println(calculator2.multiply(1,2,3))
    println(calculator2.divide(10,2,3))
    println()

    val calculator3 = Calculator3(5)
    println(calculator3.plus(5).minus(5))

}

// 가장 쉬운 방법
class Calculator1() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }

}

class Calculator2() {
    fun plus(vararg numbers: Int): Int {
        var result = 0
        numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result = numbers[0]
        for (i in 1 until numbers.size) {
            result -= numbers[i]
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result = 1
        numbers.forEach {
            if (it != 0)
                result *= it
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {
        var result = numbers[0]
        numbers.forEachIndexed() { index, value ->
            if (index != 0) {
                if (value != 0) {
                    result /= value
                }
            }
        }
        return result
    }
}

class Calculator3(val initialvalue: Int) {
    fun plus(number:Int) : Calculator3 {
        val result = this.initialvalue + number
        return Calculator3(result)
    }

    fun minus(number:Int) : Calculator3 {
        val result = this.initialvalue - number
        return Calculator3(result)
    }

    fun multiply(number:Int) : Calculator3 {
        val result = this.initialvalue * number
        return Calculator3(result)
    }

    fun divide(number:Int) :Calculator3 {
        val result = this.initialvalue / number
        return Calculator3(result)
    }
}