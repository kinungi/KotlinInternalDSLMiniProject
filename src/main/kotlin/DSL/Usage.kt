package DSL

fun main() {
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
    println(h)
}
//    val h = house {
//        room {
//            person {
//                name = "frank"
//                age = 29
//            }
//            person(name = "Chris") {
//                age = 21
//            }
//            person("Maria", 24)
//            person(age = 60, name = "Inge")
//        }
//        room {
//            person {
//                name = "Per"
//                age = 50
//            }
//        }
//        room {
//            person {
//                name = "Sarah"
//                age = 40
//            }
//            person {
//                name = "Tom"
//                age = 25
//            }
//            person {
//                name = "Holly"
//                age = 52
//            }
//        }
//      println(h)
//    }
//
