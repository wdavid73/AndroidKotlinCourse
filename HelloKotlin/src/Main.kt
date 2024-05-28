class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    // FUNCIONES DE ORDEN SUPERIOR

    cookies.forEach {
        println("Menu item: ${it.name}")
    }
    println("-------------------")
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    fullMenu.forEach { println(it) }

    /*val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }*/
    println("-------------------")

    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("-------------------")

    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }

    println("-------------------")

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")


    // COMENTARIO
    /* HELLO WORLD */
    // println("Hello world!")

    // VARIABLES

    var myString = "Esto es un String"
    myString = "Otro String"
    // myString = 5 Error
    // println(myString)


    var myString2: String = "Este es otro string"
    // println(myString2)

    var myInt = 11
    // println(myInt)

    var myDouble = 2.5
    // println(myDouble)

    var myFloat = 6.7f
    // println(myFloat)

    var myBool = true
    // println(myBool)

    val myConst = "Constante"
    // myConst = "Otro valor constante"

    // CONTROL DE FLUJOS
    myInt = 11
    /*if (myInt == 10 && myBool == true) {
        println("El valor es 10")
    } else if (myInt == 11 || myConst == "Constante") {
        println("El valor es 11")
    } else {
        println("El valor es distinto de 10 y 11")
    }*/

    // LIST

    val myList = listOf("Wilson", "Padilla", "Guicho")
    // println(myList)

    val myListMutable = mutableListOf("Wilson", "Padilla", "@Guicho")
    myListMutable.add("Wilson")
    // println(myListMutable)

    // Sets

    val mySet = setOf("Wilson", "Padilla", "@Guicho","Wilson")
    // println(mySet)

    // Maps

    val myMap = mutableMapOf("Wilson" to 25,"Wilson3" to 35,"Wilson2" to 45)
    myMap["sowil"] = 16
    // println(myMap)
    // println(myMap.get("Wilson"))

    // Bucles

    /*for (value in myList) {
        println(value)
    }*/


    /*for (value in mySet) {
        println(value)
    }*/

    /*for (value in myMap) {
        println(value)
    }*/

    var myCounter = 0
    while (myCounter <= myList.count() - 1) {
        //  println(myList[myCounter])
        myCounter++
    }

    // Optionals

    var myOptional: String? = null
    // println(myOptional)
    myOptional = "PRUEBA"
    // println(myOptional)


    // Functions
    myFunction()

    // Class

    var myClass = MyClass("Wilson", 25)

    // println(myClass.name)
    // println(myClass.age)

    // println("Este es mi nombre: ${myClass.name}")



}


fun myFunction() {
    // println("Esto es una function")
}

// Class

class MyClass(val name: String, val age: Int)