fun main() {
    var hasSword = false
    var ran = false
    var defeatedMonster = false
    var hasKey = false
    var wentBack = false

    println("Welcome to my Text Adventure, wanna start?" +
            " (y, n)(In between those '()' are options you could choose.  Don't use a wrong option else there will be an error")
    var userInput: String = readln()

    while(true) {
        if(userInput == "y") {
            if(ran) {
                println("You ran. Where do you wanna go now? (east, west)")
                ran = false
            } else if(defeatedMonster){
                if(wentBack) {
                    println("You went back. What now? (path, car)")
                } else {
                    println("You wanna escape this dangerous place but you see a car and another path. Where do you go? (path, car)")
                }
                userInput = readln()
                if(userInput == "car") {
                    println("You go to the car. What now? (start, back)")
                    userInput = readln()
                    if(userInput == "start") {
                        if (hasKey) {
                            println("You've successfully started the car. And drove away. (The end)")
                            break
                        } else {
                            println("You need a key to start this car.")
                            userInput = "y"
                            wentBack = true
                            continue
                        }
                    } else if(userInput == "back") {
                        wentBack = true
                        userInput = "y"
                        continue
                    } else {
                        throw IllegalArgumentException("Invalid Input")
                    }
                } else if(userInput == "path") {
                    if(!hasKey) {
                        println("You found a key!")
                        hasKey = true
                        userInput = "y"
                        wentBack = true
                        continue
                    } else {
                        println("This is the path you got the key.")
                        userInput = "y"
                        wentBack = true
                        continue
                    }
                } else {
                    throw IllegalArgumentException("Invalid Input")
                }
            } else if(hasSword){
                println("Where do you wanna go now? (east, west)")
            } else {
                println("You are walking on a path and you see 2 different paths. The east path and the west path. (east, west)")
            }
            userInput = readln()
            if(userInput == "east") {
                println("There is a monster!! (run, attack)")
                userInput = readln()
                if(userInput == "run") {
                    userInput = "y"
                    ran = true
                    continue
                } else if(userInput == "attack") {
                    if (hasSword) {
                        println("You defeated the monster with your sword!")
                        defeatedMonster = true
                        userInput = "y"
                        continue
                    } else {
                        println("The monster killed you. (Game over.)")
                        break
                    }
                }
                else {
                    throw IllegalArgumentException("Invalid Input")
                }
            } else if(userInput == "west") {
                if(!hasSword) {
                    println("You got a sword!")
                    userInput = "y"
                    hasSword = true
                } else {
                    println("This is where you found your sword but you already have it.")
                    userInput = "y"
                }
            } else {
                throw IllegalArgumentException("Invalid Input")
            }
        }
        else if (userInput == "n") {
            println("Bye!")
            break
        } else {
            throw IllegalArgumentException("Invalid Input.")
        }
    }
    println("Thanks for playing!")
}
