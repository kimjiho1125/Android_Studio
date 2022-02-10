package com.example.myapplication.Kotlin.Kotlin

// 28. 인터페이스
// - 인터페이스도 구현이 있는 함수를 만들 수 있다
// - 인터페이스에 구현이 되어있는 함수는 구현하려는 클래스에서
//   그 함수를 다시 구현할 필요가 없다
// - abstract -> 반드시 구현해야 한다
// - 인터페이스에 구현이 없는 함수는 그 인터페이스를 구현하는 클래스에서
//   그 한수를 반드시 구현해야 한다

fun main(args: Array<String>) {

    val student = Student__()
    student.sleep()
    student.eat()
}

interface Person__ {
    fun eat() {
        println("먹는다")
    }

    fun sleep() {
        println("잔다")
    }

    abstract fun study()
}

class Student__ : Person__ {
    override fun study() {
    }
}

class Teacher__ : Person__ {
    override fun study() {

    }
}