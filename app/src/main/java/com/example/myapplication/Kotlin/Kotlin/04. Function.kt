package com.example.myapplication.Kotlin.Kotlin

// 04. Function
// - 함수
//      - 어떤 input 을 넣어주면 어떤 output 이 나오는 것

// - 함수를 선언하는 방법
// fun 함수명 (변수명: 타입, 변수명: 타입 ...) : 반환형 {
//     함수 내용
//     return 반환값
// }

fun plus(first : Int, second : Int): Int {
    val result : Int = first + second
    return result
}

fun main(array: Array<String>){
    // 함수를 호출 하는 방법
    val result = plus(5,10);
    println(result)
    // 매개변수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 30) //명시적
    println(result2)

    val result3 = plus(second = 100 , first = 10) // 명시적 순서 바꿔서
    println(result3)
}