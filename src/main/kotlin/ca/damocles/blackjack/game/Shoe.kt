package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import ca.damocles.collections.Shuffleable
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value

class Shoe(numberOfHands: Int): Shuffleable<Card> {

    override val cards: MutableList<Card> = mutableListOf()

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

}