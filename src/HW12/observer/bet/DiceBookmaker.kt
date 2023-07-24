package HW12.observer.bet

import HW12.isEven
import HW12.observer.interfaces.IObservable
import HW12.observer.interfaces.IObserver

/**
 * DiceBookmaker.
 *
 * This class creates a bookmaker that allows you to create bets
 */

class DiceBookmaker {
    private val diceRoller = DiceRoller()

    /**
     * Starts the event
     *
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
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientForSumEqual(value)
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if (firstValue + secondValue == value ){
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на сумму чисел равную $value!")
        return BetCreateResult.OK
    }

    /**
     * Creates a bet on the sum of two numbers on the dice less than the value
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will be less than two dice give in total;
     * @param person The person who places the bet.
     */
    fun createBetOnSumOfDiceValuesLessThan(betAmount: Double, value: Int, person: Person): BetCreateResult {
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientForSumLessThan(value)
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if (firstValue + secondValue < value ){
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на сумму чисел меньше $value!")
        return BetCreateResult.OK
    }

    /**
     * Creates a bet on the sum of two numbers on the dice grater than the value
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will be grater than two dice give in total;
     * @param person The person who places the bet.
     */
    fun createBetOnSumOfDiceValuesGraterThan(betAmount: Double, value: Int, person: Person): BetCreateResult {
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientForSumGraterThan(value)
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if (firstValue + secondValue > value ){
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на сумму чисел больше $value!")
        return BetCreateResult.OK
    }


    /**
     * Creates a bet on the appearance of a value on one of the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param value The value that will appear on one of the two dice
     * @param person The person who places the bet.
     */
    fun createBetOnAppearanceOfNumber(betAmount: Double, value: Int, person: Person): BetCreateResult {
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientForAppearanceOfNumber(value)
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if (firstValue == value || secondValue == value ){
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на значение $value!")
        return BetCreateResult.OK
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
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientForAppearanceOfTwoNumbers(first, second)
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if (firstValue == first && secondValue == second) {
                    println("${person.name} выиграл ${betAmount*coefficient}$!")
                    person.balance += betAmount*coefficient
                } else if (firstValue == second && secondValue == first){
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на значения $first и $second!")
        return BetCreateResult.OK
    }

    /**
     * Creates a bet on the appearance of a value on one of the two dice
     *
     * @param betAmount The amount that a person puts on this bet;
     * @param isEven The sum of the two dice numbers will be even
     * @param person The person who places the bet.
     */
    fun createBetOnEvenSum(betAmount: Double, isEven: Boolean, person: Person): BetCreateResult {
        if(betAmount <= 0)
            return BetCreateResult.INVALID_VALUE
        if(person.balance < betAmount)
            return BetCreateResult.LOW_BALANCE

        val coefficient = DiceCoefficient.calculateCoefficientSumIsEven()
        if(coefficient.equals(0.0))
            return BetCreateResult.VALUE_OUT_OF_RANGE

        person.balance -= betAmount

        diceRoller.addObserver(object: IObserver{
            override fun update(observable: IObservable, data: Any?) {
                val result = data as Pair<*, *>
                val firstValue = result.first as Int
                val secondValue = result.second as Int

                if ((firstValue + secondValue).isEven() == isEven) {
                    println("${person.name} выиграл ${"%.2f".format(betAmount*coefficient)}$!")
                    person.balance += betAmount*coefficient
                } else {
                    println("${person.name} проиграл свою ставку")
                }
            }
        })

        println("${person.name} сделал ставку на ${ if (isEven) "чётную" else "нечетную" } сумму чисел!")
        return BetCreateResult.OK
    }
}