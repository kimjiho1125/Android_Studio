package com.example.myapplication.Kotlin.Kotlin

// 02. 자료형
// 정수형 -> Long > Int > Short > Byte
// 실수형 -> Double > Float
// 문자 ->  Char
// 문자열 -> String
// 논리형(True/False) -> Boolean

// 변수 선언하는 방법(1)
// Variable/Value 변수명 = 값
// var/val 변수명 = 값
var number = 10

// 변수 선언하는 방법(2)
// var/val 변수 : 자료형 = 값
var number1: Int = 20
var hello1: String = "Hello"
var point1: Double = 3.4

// Variable or Value?
// -1. 변하지 않는 값 -> Value
// -2. 변하는 값 or 모르겠다 -> Variable

fun main(array: Array<String>) {
    number = 20
    //number = 10.1
}