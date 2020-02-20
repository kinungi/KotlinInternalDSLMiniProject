package NoDSL

import model.House
import model.Person
import model.Room

fun main() {
    val room1 =  Room(listOf(
        Person("Mariana", 33),
        Person("Mariana", 33),
        Person("Francis", 29)))
    val room2 = Room(listOf(
        Person("Chris", 45)))
    val room3 = Room(listOf())
    val house = House(listOf(room1,room2,room3))
    println(house)
}