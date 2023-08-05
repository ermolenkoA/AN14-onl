package HW12.observer

import HW12.observer.bet.BetCreateResult
import HW12.observer.bet.DiceBookmaker
import HW12.observer.bet.Person

fun main() {
    val kirill = Person("Kirill", 1000.0)
    val artem = Person("Artem", 1000.0)
    val ilya = Person("Ilya", 1000.0)

    val bookmaker = DiceBookmaker()
    bookmaker.createBetOnSumOfDiceValuesEqual(1000.0, 7, ilya)
    bookmaker.createBetOnSumOfDiceValuesGraterThan(300.0, 7, kirill)
    bookmaker.createBetOnAppearanceOfNumber(300.0, 3, artem)

    bookmaker.startGame()
    println(kirill.balance)
}