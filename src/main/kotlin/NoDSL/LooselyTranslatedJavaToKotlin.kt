package NoDSL
import model.House
import model.Person
import model.Room
fun main() {
    val rooms =  mutableListOf<Room>()
    val people = mutableListOf<Person>()
    people.add(Person("Inge", 55))
    people.add(Person("Chris", 45))
    people.add(Person("Sebastian", 24))
    val room1 = Room(people)
    rooms.add(room1)
    val house = House(rooms)
    println(house)
}