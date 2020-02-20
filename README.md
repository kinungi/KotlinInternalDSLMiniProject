
#Internal DSL in Kotlin for a Simple House Game

The idea is to create a model to simulate a kind of “house game” where objects and their contents are described.  
The intention is to use some dummy objects, infix functions, lambda with receivers, extension functions 
to help reduce DSL fluency and enhance readability.

The model consists of three objects: the house, the rooms it contains, and the people who are in those rooms. 
The result of the implementation will show some sort of hierarchy chaining] of the objects.
This DSL is aimed to show some progress on code readability and quicker ways to modify the code, 
that would not perhaps be possible if we were to use Java syntax. Here is a code snippet without DSL. 
```kotlin

val rooms = mutableListOf<Room>() 
val people = mutableListOf<Person>()
 people.add(Person("Inge", 55))
 people.add(Person("Chris", 45))
 people.add(Person("Sebastian", 24))
 val room1 = Room(people)
 rooms.add(room1)
 val house = House(rooms)
 println(house)

```
Let slightly improved this code by nesting the calls and using 
the Kotlin factory functions for collections provided by Kotlin.
```kotlin

val room1 =  Room(listOf(
       Person("Mariana", 33),
       Person("Mariana", 33),
       Person("Francis", 29)))
  val room2 = Room(listOf(
      Person("Chris", 45)))
  val room3 = Room(listOf())
  val house = House(listOf(room1,room2,room3))
  println(house)
```
This code snippet is somewhat easier to write, read and maintain than 
the previous even though the hierarchy is not appealing yet. 
If the model gets larger the problem will be just like the previous code 

#DSL
Following the conventions mostly used by DSL authors, the previous code can already 
be significantly improved by using Kotlin functionalities and syntax. Lambda with receiver, 
companion object, infix functions and extension functions.   
```kotlin

val h =  house containing rooms {
     room with people {
         "chris" age 47
         "Inge" age 54
     }
     room with people {
         "Francis" age 29
     }
     room without people
     room with people {
         "James" age 33
         "peter".capitalize() age 52
     }
 }
```
Now the code her showcase variety of different ways for calling a person object.  
We can see that with the how some Kotlin functionalities can help to curb 
the modification trouble of the non-DSL approaches. 
Here the blocks can be moved around freely and easily. 



