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
    var bigCar1: Car = Car("v8 engine", "big")

    var superCar: SuperCar = SuperCar("good engine", "big", "white")

    // 인스턴스가 가지고 있는 기능을 사용하는 방법
    var runableCar: RunableCar = RunableCar("Simple engine", "short body")
    runableCar.ride()
    runableCar.navi("부산")
    runableCar.drive()

    // 인스턴스의 멤버변수에 접근하는 방법
    val runableCar2: RunableCar2 = RunableCar2("nice engine", "long body")
    println(runableCar2.engine)
    println(runableCar2.body)

    println()
    val testClass : TestClass = TestClass()
    testClass.test(1)
    testClass.test(1,2)

}

// 클래스 만드는 방법 (1)
class Car(var engine: String, var body: String) {

}

// 클래스 만드는 방법 (2)
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스 만드는 방법 (3) -> 1번 방법의 확장
class Car1(engine: String, body: String) {
    var door: String = ""

    //생성자
    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

// 클래스 만드는 방법 (4) -> 2번 방법의 확장
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String) {

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive() {
        println("달립니다 !")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }

}

class RunableCar2 {
    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init {
        // 인스턴스화 될때 가장 먼저 호출됨
        // 각종 초기화를 하는데 유용함
        println("RunableCar2가 만들어 졌습니다")
    }

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive() {
        println("달립니다 !")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

// 오버로딩
// - 이름이 같지만 받는 파라미터가 다른 함수
class TestClass() {

    // 이름이 같으나 파라미터가 달라서 구별이 가능
    fun test(a: Int) {
        println("up")
    }

    fun test(a: Int, b: Int) {
        println("down")
    }

}