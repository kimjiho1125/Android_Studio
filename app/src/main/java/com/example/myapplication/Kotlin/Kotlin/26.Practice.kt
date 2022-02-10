package com.example.myapplication.Kotlin.Kotlin

// 과제
// Night, Monster (부모) -> Character
// SuperNight, SuperMonster (자식)

//fun main(args: Array<String>) {
//    val superNight : SuperNight = SuperNight(350,100)
//    val superMonster: SuperMonster = SuperMonster(400,60)
//
//    superNight.attack(superMonster)
//    superMonster.attack(superNight)
//    superNight.specialMove(superMonster)
//    superMonster.heal(superMonster)
//}
//
//class SuperNight(private var hp: Int, private var power: Int) : Night(hp, power) {
//    fun specialMove(monster: Monster) {
//        monster.defense(power + 50)
//    }
//}
//
//class SuperMonster(private var hp: Int, private var power: Int) : Monster(hp, power) {
//    fun heal(superMonster: SuperMonster) {
//        hp += 20
//        println("몬스터 현재 체력은 $hp 입니다")
//    }
//}

fun main(args: Array<String>) {
    val monster = SuperMonster(100, 10)
    val night = SuperNight(130,8)
    monster.attack(night)
    monster.bite(night)

}


open class Character(var hp: Int,val power: Int) {
    fun attack(character: Character, power: Int = this.power) {
        character.defense(power)
    }
    open fun defense(damage: Int) {
        hp -= damage
        if(hp>0) println("${javaClass.simpleName}의 남은 체력은 ${hp}입니다")
        else println("사망했습니다")
    }
}

// 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스가 선행되서 인스턴스화 되어야 한다
class SuperMonster(hp: Int, power: Int) : Character(hp, power) {
    fun bite(character: Character) {
        super.attack(character, power + 2)
    }
}

class SuperNight(hp: Int, power: Int) : Character(hp, power) {
    val defensePower = 2
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}