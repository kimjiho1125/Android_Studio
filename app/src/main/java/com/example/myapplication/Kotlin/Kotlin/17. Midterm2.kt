package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {
    first2()
    println(second2(80))
    println(third2(89))
    gugudan2()
}

fun first2() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })

    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)

    list1.forEachIndexed { index, value ->
        if ((value % 2) == 0) {
            //짝수
            list2[index] = true
        } else {
            //홀수
            list2[index] = false
        }
    }
    println(list2)
}

fun second2(score: Int): String {
    when (score) {
        in 90..100 -> {
            return "A"
        }
        in 80..89 -> {
            return "B"
        }
        in 70..79 -> {
            return "C"
        }
        in 60..69 -> {
            return "D"
        }
        else -> {
            return "F"
        }
    }
}

fun third2(number: Int): Int {
    // 89 = 8 + 9
    val a: Int = number / 10
    val b: Int = number % 10
    return a + b
}

fun gugudan2() {
    for (x in 1..9){
        for (y in 1..9){
            println("${x} * ${y} = ${x*y}")
        }
    }
}