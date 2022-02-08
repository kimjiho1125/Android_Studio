package com.example.myapplication.Kotlin.Kotlin

fun main(array: Array<String>) {

    val channels = listOf<String>("K", "M", "S")
    val tv = TV1(channels)

    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.currentChannelNumber


}

class TV1(val channels: List<String>) {

    var onOrOff: Boolean = false
    var currentChannelNumber = 0
        set(value) {
            field = value
            if (field > 2) {
                field = 0
            }
            if (field < 0) {
                field = 2
            }
        }
        get() {
            println("호출되었습니다")
            return field
        }

    fun switch() {
        onOrOff = !onOrOff
    }

    fun channelUp() {
        currentChannelNumber++
//        channels.forEachIndexed { index, s ->
//            if(currentChannelNumber == index){
//                currentChannelNumber++
//                return
//            }
//        }
    }

    fun channelDown() {
        currentChannelNumber--
//        channels.forEachIndexed { index, s ->
//            if(currentChannelNumber == index){
//                currentChannelNumber--
//                return
//            }
//        }
    }

    fun checkCurrentChannel(): String {
        return channels[currentChannelNumber]
    }
}