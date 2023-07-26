package HW12.observer

import HW12.observer.bet.BetCreateResult
import HW12.observer.bet.DiceBookmaker
import HW12.observer.bet.Person

fun main() {
    val artem = Person("Artem", 1300.0)
    val sasha = Person("Sasha", 1000.0)
    val dima = Person("Dima", 1200.0)

    val bookmaker = DiceBookmaker()
    bookmaker.createBetOnEvenSum(1000.0, true, artem)
    bookmaker.createBetOnSumOfDiceValuesLessThan(900.0, 10, sasha)
    bookmaker.createBetOnAppearanceOfNumber(100.0, 2, dima)

    bookmaker.startGame()
}