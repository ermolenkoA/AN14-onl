package HW12.observer.bet

import HW12.isEven
import HW12.observer.interfaces.IObservable
import HW12.observer.interfaces.IObserver

/**
 * This class creates a bookmaker that allows you to create bets
 */

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
     * Creates a bet on the sum of two numbers on the dice less than the value
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will be less than two dice give in total;
     * @param person The person who places the bet.
     */
    fun createBetOnSumOfDiceValuesLessThan(betAmount: Double, value: Int, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person,
            DiceCoefficient.calculateCoefficientForSumLessThan(value)){
            it.first + it.second < value
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ on the sum of numbers less than $value")
        return createResult
    }

    /**
     * Creates a bet on the sum of two numbers on the dice grater than the value
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will be grater than two dice give in total;
     * @param person The person who places the bet.
     */
    fun createBetOnSumOfDiceValuesGraterThan(betAmount: Double, value: Int, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person,
            DiceCoefficient.calculateCoefficientForSumGraterThan(value)){
            it.first + it.second > value
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ on the sum of numbers greater than $value")
        return createResult
    }

    /**
     * Creates a bet on the appearance of a value on one of the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will appear on one of the two dice;
     * @param person The person who places the bet.
     */
    fun createBetOnAppearanceOfNumber(betAmount: Double, value: Int, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person,
            DiceCoefficient.calculateCoefficientForAppearanceOfNumber(value)){
            it.first == value || it.second == value
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ on the number $value")
        return createResult
    }

    /**
     * Creates a bet on the appearance of a value on one of the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param first The value that will appear on one of the two dice;
     * @param second The value that will appear on one of the two dice;
     * @param person The person who places the bet.
     */
    fun createBetOnAppearanceOfTwoNumbers(betAmount: Double, first: Int, second: Int, person: Person): BetCreateResult {
        val createResult = createBet(betAmount, person,
            DiceCoefficient.calculateCoefficientForAppearanceOfTwoNumbers(second,first)){
            (it.first == first && it.second == second) || (it.first == second && it.second == first)
        }

        if(createResult == BetCreateResult.OK)
            println("${person.name} placed a bet of ${"%.2f".format(betAmount)}\$ on the numbers $first and $second")
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