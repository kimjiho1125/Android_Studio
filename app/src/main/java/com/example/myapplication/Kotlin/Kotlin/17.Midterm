package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {

    first()
    println(second(80))
    println(third(89))
    gugudan()
}

// 1번 문제
fun first() {

    // List 를 두개 만든다
    var numberList1 = mutableListOf<Int>()
    var numberList2 = mutableListOf<Boolean>()

    // 첫 번째 List 에는 0 부터 9까지 값을 넣는다 (반복문 사용)
    for (i in 0..9) {// ..은 마지막을 포함 한다 -> 0~9
        numberList1.add(i)
    }
    // 두 번째 List 에는 첫 번째 List 의 값을 하나씩 확인한 후
    // 짝수면 True 홀수면 False 를 넣어 준다
    for (i in 0..9) {
        if ((numberList1[i] % 2) == 0) { //짝수면
            numberList2.add(true)
        } else {
            numberList2.add(false)
        }
    }
    println(numberList1)
    println(numberList2)
}

fun second(score: Int): String {

    if ((score > 90) && (score <= 100)) {
        return "A"
    }// 90-100 -> A
    else if ((score > 80) && (score <= 90)) {
        return "B"
    }// 80-90 -> B
    else if ((score > 70) && (score <= 80)) {
        return "C"
    }// 70-80 -> C
    else if ((score > 60) && (score <= 70)) {
        return "D"
    }// 60-70 -> D
    else {
        return "F"
    }// 나머지 F
}

fun third(number : Int) : Int {
    // 전달 받은 숫자의 각 자리 수의 합을 구하자
    // 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다
    var number1 : Int = number/10 // 십의 자리 수
    var number2 : Int = number%10 // 일의 자리 수

    var result = number1 + number2

    return result
}

fun gugudan() {
    for (i in 2..9) {
        println("======${i}단======")
        for (j in 1..9) {
           println("${i} * ${j} = ${i*j}")
        }
    }
}




