package HW12.observer.bet

import HW12.observer.interfaces.IObservable
import HW12.observer.interfaces.IObserver
import kotlin.random.Random

class DiceRoller: IObservable {

    private var observers = mutableListOf<IObserver>()

    fun start(){
        val firstValue = rollADie()
        val secondValue = rollADie()
        println("Игра завершена! Выпали $firstValue и $secondValue")
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