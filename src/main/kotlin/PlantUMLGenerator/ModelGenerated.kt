package PlantUMLGenerator


/*
 @startuml

 class House{

+build()
+containing()
 }
  House "1..*"  -  "1..*" Room
 House *-- Room

 class Room{
 -name:String
 --
 +build()
 +room()
 }
 class Person {
 - name : String
 - age : Int
 --
 +build()
 +people()
 }
  Room "0..*"  -  "1..*" Person
@enduml
 */


/*
 @startuml
  class entity{
 -name:String
 }
 class attribute{
 -name: String
 -age: Int
 -type: String
 }
  entity "0..*"  -  "1..*" attribute

 class relation{
 liveInRoom()
 containRooms()
 }
   entity "1..*"  -  "1..*" relation
 @enduml
*/


//HouseBuilder "0..*"  -  "1..*" RoomBuilder
//(HouseBuilder, RoomBuilder) .. PersonBuilder