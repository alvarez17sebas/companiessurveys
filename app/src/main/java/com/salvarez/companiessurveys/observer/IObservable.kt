package com.salvarez.companiessurveys.observer

interface IObservable {
    fun addObserver(observer: IObserver)
    fun removeObserver(observer: IObserver)
    fun notifyObservers()
}