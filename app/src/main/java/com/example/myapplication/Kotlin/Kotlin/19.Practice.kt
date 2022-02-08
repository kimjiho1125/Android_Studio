package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {
    var calculator: Calculator = Calculator()
    println(calculator.plus(10, 5))
    println(calculator.minus(10, 5))
    println(calculator.multiply(10, 5))
    println(calculator.divide(10, 5))
    println()

    var newaccount: Account = Account("JIHO", "981125")
    newaccount.balanceCheck()
    newaccount.deposit(1000000)
    newaccount.withdraw(100000)
    println()

    var tv : TV = TV()
    tv.switch()
    tv.turnChannel()
    tv.turnChannel()
    tv.turnChannel()
    tv.turnChannel()
}

// 1) 사칙 연산을 수행할 수 있는 클래스
class Calculator() {
    fun plus(x: Int, y: Int): Int {
        return x + y;
    }

    fun minus(x: Int, y: Int): Int {
        return x - y;
    }

    fun multiply(x: Int, y: Int): Int {
        return x * y;
    }

    fun divide(x: Int, y: Int): Int {
        return x / y;
    }
}

// 2) 은행 계좌 만들기
// - 계좌 생성 기능 (이름, 생년 월일)
// - 잔고를 확인하는 기능
// - 출금 기능
// - 예금 기능
class Account(name: String, birth: String) {

    var balance: Int = 0

    init {
        println("계좌를 생성합니다....")
        println("이름 : $name")
        println("생년월일 : $birth")
        println("생성완료")
        println()
    }

    // 잔고를 확인하는 기능
    fun balanceCheck() {
        println("현재 통장 잔고 : $balance")
    }

    // 출금 기능
    fun withdraw(price: Int) {
        if (balance - price < 0) {
            println("잔고가 부족하여 출금할 수 없습니다")
        } else if (price < 0) {
            println("유효하지 않은 숫자입니다")
        } else {
            balance -= price
            println("${price}원을 출금합니다")
            println("현재 통장 잔고 : $balance")
        }
    }

    // 예금 기능
    fun deposit(price: Int) {
        if (price < 0) {
            println("유효하지 않은 숫자입니다")
        } else {
            balance += price
            println("${price}원을 예금합니다")
            println("현재 통장 잔고 : $balance")
        }
    }
}

// TV 클래스
class TV {
    var state : Boolean = false // false->off true->on
    var channel : Int = 1 // 초기채널 S사

    fun switch() {
        state = !state
        if (state == false) {
            println("현재 전원 : Off")
        }
        else {
            println("현재 전원 : On")
            if (channel == 1) {
                println("현재 채널 : S사")
            }
            else if(channel == 2) {
                println("현재 채널 : M사")
            }
            else {
                println("현재 채널 : K사")
            }
        }
    }

    fun turnChannel() {
        channel ++
        if (channel%3 == 1) {
            println("현재 채널 : S사")
        }
        else if(channel%3 == 2) {
            println("현재 채널 : M사")
        }
        else {
            println("현재 채널 : K사")
        }
    }
}