package com.salvarez.companiessurveys.observer

class Subject(var position: Int) {

    private var observers: MutableList<IObserver> = ArrayList()

    fun addObserver(observer: IObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: IObserver) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach {
            it.update(position)
        }
    }
}