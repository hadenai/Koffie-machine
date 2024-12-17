package machine

class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var money = 550
    var disposableCup = 9

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:")
        val chooseCoffee = readln()
        if(water - 250 >= 0 && coffeeBeans - 16 >= 0 && disposableCup - 1 >= 0) {
            println("I have enough resources, making you a coffee!")
        } else {
            println("Sorry, not enough material")
            return
        }
        when(chooseCoffee) {
            "1" -> { water -=  250; coffeeBeans -= 16; money += 4; disposableCup -= 1}
            "2" -> { water -=  350; milk -= 75; coffeeBeans -= 20; money += 7; disposableCup -= 1}
            "3"  -> { water -=  200; milk -= 100; coffeeBeans -= 12; money += 6; disposableCup -= 1}
            "back" -> return
        }
    }

    private fun fill() {
        println("Write how many ml of water you want to add:")
        val quantityWater = readln().toInt()
        water += quantityWater

        println("Write how many ml of milk you want to add: ")
        val quantityMilk = readln().toInt()
        milk += quantityMilk

        println("Write how many grams of coffee beans you want to add: ")
        val quantityCoffee = readln().toInt()
        coffeeBeans += quantityCoffee

        println("Write how many disposable cups you want to add: ")
        val numberCupCoffee = readln().toInt()
        disposableCup += numberCupCoffee
    }

    private fun take() {
        println("I gave you $money")
        money = 0
    }

    private fun displayContentMachine() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans g of coffee beans")
        println("$disposableCup disposable cups")
        println("$$money of money")
    }

    fun commandCoffee() {
        while(true) {
            println("Write action (buy, fill, take, remaining, exit):")
            val operation = readln()
            when(operation) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> displayContentMachine()
                "exit" -> break
            }
        }
    }
}

    fun main() {
        val coffee = CoffeeMachine()
        coffee.commandCoffee()
    }
