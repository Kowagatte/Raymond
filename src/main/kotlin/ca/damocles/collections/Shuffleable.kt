package ca.damocles.collections

import kotlin.random.Random

/**
 * Interface for Shuffleable objects, has an abstract collection called cards that will be shuffled when calling #shuffle()
 * The default implementation of the Shuffle is the Fisher-Yates Shuffle Algorithm.
 */
interface Shuffleable<E> {

    val cards: MutableList<E>

    /**
     * Fisher-Yates shuffle implementation.
     * This will be used as the default implementation for any collection that is Shuffleable.
     */
    fun shuffle(){
        var temp: E
        var j: Int
        for(i in cards.size-1 downTo 1) {
            j = Random.nextInt(0, i + 1)
            temp = cards[j]
            cards[j] = cards[i]
            cards[i] = temp
        }
    }
}