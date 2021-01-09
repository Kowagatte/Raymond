package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import ca.damocles.bicycle.Shuffleable
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value
import kotlin.random.Random

class Shoe(numberOfHands: Int): Shuffleable{

    private val cards: MutableList<Card> = mutableListOf()

    init{
        for(x in 1..numberOfHands){
            for(suit in Suit.values()){
                for(value in Value.values()){
                    cards.add(Card(suit, value))
                }
            }
        }
    }

    fun size(): Int = cards.size

    private fun decksInShoe(): Int = (cards.size/52)

    /**
     * Fisher-Yates shuffle implementation.
     */
    override fun shuffle() {
        var temp: Card
        var j: Int
        for(i in size()-1 downTo 1){
            j = Random.nextInt(0, i+1)
            temp = cards[j]
            cards[j] = cards[i]
            cards[i] = temp
        }
    }

}