package HW12.observer.interfaces

import HW12.observer.interfaces.IObservable

interface IObserver {
    fun update(observable: IObservable, data: Any?)
}