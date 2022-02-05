package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {

    val array = arrayOf<Int>(1, 2, 3)

    // get, set
    val number = array.get(0)
    println(number)
//    val number1 = array.get(100) //인덱스에 주의해야 한다

    array.set(0, 100)
    val number2 = array.get(0)
    println(number2)

//    array.set(100,100) //인덱스 범위를 벗어나서 오류가 난다
    // Array 의 Bounds
    // - 처음 만들때 결정 된다

    // Array 를 만드는 방법(3) -> 명시적이라 가장 좋음
    val a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('b', 'c') //char -> '', string -> ""
    val a3 = doubleArrayOf(1.2, 100.345)
    val a4 = booleanArrayOf(true, false, true)

    // Array 를 만드는 방법(4) -> lambda 를 활용한 방법
    val a5 = Array(10, { 0 })
    val a6 = Array(5,{1;2;3;4;5})
}