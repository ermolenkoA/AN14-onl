# **AN14-onl** :iphone: **/ Homeworks** :books:
#### Here I will publish the solved tasks for the Android App Development course
![Java](https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=coffeescript&logoColor=white) ![Kotlin](https://img.shields.io/badge/Kotlin-blueviolet?style=for-the-badge&logo=Kotlin&logoColor=blue) ![Android](https://img.shields.io/badge/Android-green?style=for-the-badge&logo=android&logoColor=black) ![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-black?style=for-the-badge&logo=intellijidea&logoColor=white) 
___
### The last homework :
[![Homework](https://icons.iconarchive.com/icons/papirus-team/papirus-places/256/folder-yellow-java-icon.png "Go to directory")](src/HW12)

### Tasks: 
-  **Create extension function for Int, Double, String**
-  **Implement the observer pattern**

### 1. Create three extension functions

For type Int I created a function to check if a number is even.  
For the Double type I created a function that returns the fractional part of a number  
For the String type I created a function that returns the number of vowels in a string

Here is the final code:
```kotlin
fun Int.isEven(): Boolean = this % 2 == 0

fun Double.fractionalPart(): Double = this - this.toInt()

fun String.countVowels(): Int {
    val vowels = "aeiouyаяуюоеёэиы"
    return this.filter{
        it.lowercase() in vowels
    }.length
}
```

### 2. Implement the observer pattern

As an example, I have implemented an observer pattern for betting on dice rolls.

The observable is the diceRoller and observer is a bet.  
The creation of bets is going through the object of DiceBookmaker, it has an object of DiceRoller inside  

As parameters are passed: 
-  bet amount (Double)
-  person who makes a bet (Person)
-  other data for this bet

After calling a bet creating function it:
- calculates the coefficient using DiceCoefficient
- checks the correctness of input data
- creates a bet
- the bookmaker added a bet as observer to DiceRoller
- returns object of BetCreateResult enum class.

The bet is created by an anonymous class that is extended by IObserver  
This class implements the method ***update()***. This method contains the logic of the bet.  
After the bookmaker rolled dice, all bets receive a result and, if it won, they return the winnings to the person balance.

Solution code (the full code is [here](src/HW12))

### Observable:
```kotlin
class DiceRoller: IObservable {

    private var observers = mutableListOf<IObserver>()
    
    /**
     * Allows to roll dice and notifies of the results
     */
    fun start(){
        val firstValue = rollADie()
        val secondValue = rollADie()
        println("\nGame over! Result $firstValue and $secondValue\n")
        notifyObservers(
            Pair<Int, Int>(firstValue, secondValue)
        )
        observers.clear()
    }

    private fun rollADie(): Int = Random.nextInt(1, 7)

    override fun addObserver(observer: IObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: IObserver) {
        observers.remove(observer)
    }

    override fun notifyObservers(data: Any?) {
        observers.forEach{
            it.update(this, data)
        }
    }
}
```
### Observer:
```kotlin
class DiceBookmaker {
    private val diceRoller = DiceRoller()

    /**
     * Starts the event
     */
    fun startGame() = diceRoller.start()

    /**
     * Creates a bet on the sum of two numbers on the dice equal to the value
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that two dice give in total;
     * @param person The person who places the bet.
     */
    fun createBetOnSumOfDiceValuesEqual(betAmount: Double, value: Int, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person,
            DiceCoefficient.calculateCoefficientForSumEqual(value)){
            it.first + it.second == value
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ on the sum equal to $value")
        return createResult
    }

    /**
     * Creates a bet on the appearance of a value on one of the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param isEven The sum of the two dice numbers will be even;
     * @param person The person who places the bet.
     */
    fun createBetOnEvenSum(betAmount: Double, isEven: Boolean, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person, DiceCoefficient.calculateCoefficientSumIsEven()){
            (it.first + it.second).isEven() == isEven
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ for the ${if (isEven) "even" else "odd"} sum")
        return createResult
    }

    /**
     * Creates a bet on the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param person The person who places the bet;
     * @param coefficient The coefficient that increases the initial amount when winning;
     * @param betWinLogic The function that has winning logic built into it. Pair<Int, Int> is values of two dice;
     */

    private fun createBet(betAmount: Double,
                          person: Person,
                          coefficient: Double,
                          betWinLogic: (Pair<Int, Int>) -> Boolean): BetCreateResult {
        if(betAmount <= 0)
            return BetCreateResult.INVALID_BET_AMOUNT
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                @Suppress("UNCHECKED_CAST")
                (data as? Pair<*, *>)?.let {
                    if(it.first !is Int && it.second !is Int)
                        return
                    if (betWinLogic(it as Pair<Int, Int>)) {
                        println("${person.name} won ${"%.2f".format(betAmount*coefficient)}$!")
                        person.balance += betAmount*coefficient
                    } else {
                        println("${person.name} lost the bet")
                    }
                }
            }
        })

        return BetCreateResult.OK
    }
}
```




