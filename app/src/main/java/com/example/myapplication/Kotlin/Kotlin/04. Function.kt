package com.example.myapplication.Kotlin.Kotlin

// 04. Function
// - 함수
//      - 어떤 input 을 넣어주면 어떤 output 이 나오는 것

// - 함수를 선언하는 방법
// fun 함수명 (변수명: 타입, 변수명: 타입 ...) : 반환형 {
//     함수 내용
//     return 반환값
// }

fun plus(first: Int, second: Int): Int {
    val result: Int = first + second
    return result
}

// - 디폴트 값을 갖는 함수 만들기
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

// - 반환값이 없는 함수 만들기
fun printplus(first: Int, second: Int): Unit { // :unit 생략가능
    val result: Int = first + second
    println(result)
}

// - 반환값이 없는 함수 만들기(2)
fun printplus2(first: Int, second: Int) {
    val result: Int = first + second
    println(result)
}

// - 간단하게 함수를 선언하는 방법
fun plusShort(first: Int, second: Int) = first + second

// - 가변인자를 갖는 함수 선언하는 방법
fun plusMany(vararg numbers: Int) {
    for(number in numbers){
        println(number)
    }
}

fun main(array: Array<String>) {
    // 함수를 호출 하는 방법
    val result = plus(5, 10);
    println(result)
    // 매개변수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 30) //명시적
    println(result2)

    val result3 = plus(second = 100, first = 10) // 명시적 순서 바꿔서
    println(result3)

    // 디폴트 값을 갖는 함수 호출하기
    val result4 = plusFive(10, 20)
    println(result4)

    val result5 = plusFive(10)
    println(result5)

    println()
    printplus(10, 20)
    printplus2(10, 20)

    val result6 = plusShort(50, 50)
    println(result6)

    println()
    plusMany(1,2,3)
    plusMany(100)
}