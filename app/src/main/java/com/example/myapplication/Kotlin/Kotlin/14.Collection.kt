package com.example.myapplication.Kotlin.Kotlin

// 14. Collection
// -> list, set, map

fun main(array: Array<String>) {

    // Immutable Collection (변경 불가능)
    // List -> 중복을 허용한다
    val numberList = listOf<Int>(1, 2, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set
    // -> 중복을 허용하지 않는다
    // -> 순서가 없다다
    val numberSet = setOf<Int>(1, 2, 3, 3, 3)
    println(numberSet)
    numberSet.forEach {
        println(it)
    }

    // Map -> Key,Value 방식으로 데이터를 관리한다
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println(numberMap)
    println()
    println(numberMap.get("one"))

    // Mutable Collection (변경 가능)
    val mNumberList = mutableListOf<Int>(1, 2, 3)
    mNumberList.add(3, 4)
    println()
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(mNumberMap)
}