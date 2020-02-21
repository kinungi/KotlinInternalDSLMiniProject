package DSL

import model.House
import model.Person
import model.Room

@DslMarker
annotation class SimpleGameDSL
object house{
    //function marked with the infix keyword can be called using the infix notation(omitting the dot and the parenthesis for the call)
    infix fun containing(rooms:List<Room>) = House(rooms)
}
object room
class PeopleListBuilder{
    private  val people =  mutableListOf<Person>()
    fun build():List<Person> = people

    infix  fun String.age(age:Int){  //extension function
        people.add(Person(this,age))
    }
}
fun people(activities: PeopleListBuilder.() -> Unit):List<Person>{ //lambda with receiver
    val builder = PeopleListBuilder()
    builder.activities()
    return builder.build()
}
//fun person(actions: PeopleListBuilder.() -> Unit) = people(actions)
object people
class RoomListBuilder {
    private  val rooms =  mutableListOf<Room>()
    fun build():List<Room> = rooms
    infix  fun room.with(people:List<Person>){
        rooms += Room(people)
    }
    infix  fun room.of(people: List<Person>) = with(people)
    //room without people. more functionality maybe implemented in future
    infix  fun room.without(p:people){
        rooms += Room(listOf())
    }
}
fun rooms(activities: RoomListBuilder.() -> Unit):List<Room>{
    val builder = RoomListBuilder()
    builder.activities()
    return builder.build()
}
/**
 * build function is allowing to construct a string from several pieces of content
 * the function people, room and house allows to construct a string from several pieces of content
 * */
// A room can have

// Without using object and infix function.
//class PersonBuilder(var name: String, var age: Int) {
//    fun build():Person {
//        return  Person(name, age)
//    }
//}
//class RoomBuilder{
//    private  val people = mutableListOf<Person>()
//    fun build(): Room {
//        return Room(people)
//    }
//    fun person(name:String = "", age:Int = 0, setup: PersonBuilder.() -> Unit = {}){
//        val  personalBuilder = PersonBuilder(name, age)
//        personalBuilder.setup()
//        people += personalBuilder.build()
//    }
//}
//class HouseBuilder {
//    private  val rooms = mutableListOf<Room>()
//    operator  fun Room.unaryPlus(){ //return this value
//      rooms += this
//    }
//    // lambda with receiver let you to refer its member directly without any quantifier
//    fun room(setup: RoomBuilder.() -> Unit = {}) {
//       val roomBuilder = RoomBuilder()
//        roomBuilder.setup()
//        rooms += roomBuilder.build()
//    }
//    fun build():House {
//        return House(rooms)
//    }
//   // fun houseGame.house(param:() -> Unit){}
//}
//fun house(setup: HouseBuilder.() ->Unit): House {
//    val houseBuilder = HouseBuilder()
//    houseBuilder.setup()
//    return houseBuilder.build()
//}
