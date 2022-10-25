package com.example.gamecards.data.arq

import androidx.lifecycle.Observer

/**
 * Igor Santos
 * 24/10/2022
 */

/**
 * Data holder para o valor sendo emitido pelo LiveData
 */
open class Event<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peek(): T = content

    fun markHandled() {
        hasBeenHandled = true
    }
}

/**
 * Um observer que lê o valor do Event UMA UNICA VEZ
 */
class EventObserver<T>(private val onEventUnhandled: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getIfNotHandled()?.let { value ->
            onEventUnhandled(value)
        }
    }
}