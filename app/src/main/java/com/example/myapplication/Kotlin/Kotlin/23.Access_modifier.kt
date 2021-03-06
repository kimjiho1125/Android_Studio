package com.example.myapplication.Kotlin.Kotlin

import com.example.myapplication.R

// 23. 접근 제어자

fun main(array: Array<String>) {
    var testAccess : TestAccess = TestAccess("아무개")
    // Private 키워드 때문에 더 이상 외부에서 접근할 수 없다
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "아무개 투"
//    println(testAccess.name)

    var reward : Reward = Reward()
    reward.rewardAmount = 2000

    var runningCar : RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run

}
class Reward() {
    var rewardAmount : Int = 1000
}

class TestAccess {
    private var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName:String) {
        this.name = newName
    }

    private fun test() {
        println("테스트")
    }
}

class RunningCar(){
    fun runFast() {
        run()
    }

    private fun run() {

    }
}