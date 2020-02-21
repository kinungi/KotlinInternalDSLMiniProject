
# Internal DSL in Kotlin for a Simple Game

The idea is to create a model to simulate a kind of “house game” where objects and their contents are described.  
The implementations are based on Kotlin syntax and its functionalities such as companion objects, infix functions, 
lambda with receivers, extension functions to help reduce DSL fluency and enhance readability.

The model consists of three objects: the house, the rooms it contains, and the people who are in those rooms. 
```kotlin
data class Person(val name: String, val age:Int)
data class Room(val people:List<Person>)
data class House(val rooms: List<Room>)
```
The result of the implementation will show some sort of hierarchy [chaining] of the objects. 
The DSL is aimed to show some progress on code readability and easier ways to modify the code, 
that perhaps would not be possible if we were to use Java.

Here is a code snippet loosely translated from java to kotlin
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
Now, the above code is somewhat verbose, a non-tech guy might not understand what is going on here. 
Let slightly improved this code by nesting the calls and using the Kotlin factory functions for collections provided by Kotlin.
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
The code snippet is somewhat easier to write, read and maintain than 
the previous even though the hierarchy is not appealing yet. 
If the model gets larger the problem will be just like the previous code 
# DSL
Following the examples mostly used by DSL authors, the previous code can already 
be significantly improved by using Kotlin functions such as  Lambda with receiver, 
infix functions and extension functions.   
```kotlin
val h = house {
        room {
            person {
                name = "frank"
                age = 29
            }
            person("Maria", 24)
            person(age = 60, name = "Inge")
        }
        room {
            person {
                name = "Sarah"
                age = 40
            }
        }
      println(h)
    }
```
Now the code her showcase variety of different ways for calling a person object.  
We can see that with the how some Kotlin functionalities can help to curb 
the modification trouble of the non-DSL approaches. 
Here the blocks can be moved around freely and easily. 
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
Even more improved using the companion objects and infix functions. 

The code is organised into four packages:
- model- contains  data classes
- DSL - implementation and usage file. run the code through the usage.kt file
- plantUmlGenerator - contains the auto generated model
- NoDSL- contains implementation sample without DSL.

# Output
```kotlin
House(rooms=[Room(people=[Person(name=chris, age=47), Person(name=Inge, age=54)]), Room(people=[Person(name=Francis, age=29)])])
```
# future work
As mentioned in the beginning, the idea was to implement a very simple internal DSL. 
More like chaining objects and read the code like a sentence. 
The implementation is very basic and more logic can be extended/implemented as future work.  




