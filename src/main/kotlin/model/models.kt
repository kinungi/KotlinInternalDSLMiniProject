package model

data class Person(val name: String, val age:Int)
data class Room(val people:List<Person>)
data class House(val rooms: List<Room>)