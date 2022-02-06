package com.example.myapplication.Kotlin.Kotlin

// 18. Class
// OOP -> Object Oriented Programming (객체지향 프로그래밍)

// 객체를 만드는 방법
// - 설명서가 있어야 한다

fun main(array: Array<String>) {
    // 클래스를 통해서 객체를 만드는 방법
    // -> 인스턴스화 -> 인스턴스(객체)
    Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")

    // 우리가 만든 클래스는 자료형이 된다
    var bigCar1 : Car = Car("v8 engine", "big")

    var superCar : SuperCar = SuperCar("good engine", "big", "white")
}

// 클래스 만드는 방법 (1)
class Car(var engine : String, var body: String) {

}
// 클래스 만드는 방법 (2)
class SuperCar{
    var engine : String
    var body : String
    var door : String

    constructor(engine: String, body: String, door: String){
        this.engine = engine
        this.body = body
        this. door = door
    }
}