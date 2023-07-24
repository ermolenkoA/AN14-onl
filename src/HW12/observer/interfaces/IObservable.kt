package HW12.observer.interfaces

interface IObservable {
    fun addObserver(observer: IObserver)
    fun removeObserver(observer: IObserver)
    fun notifyObservers(data: Any?)
}