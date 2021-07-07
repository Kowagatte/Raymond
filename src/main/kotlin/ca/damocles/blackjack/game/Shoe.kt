package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import ca.damocles.collections.Shuffleable
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value
import ca.damocles.bicycle.getEmptyDeck

/**
 *
 */
class Shoe(numberOfDecks: Int): Shuffleable<Card> {

    override val cards: MutableList<Card> = mutableListOf()

    init{
        for(x in 1..numberOfDecks){
            cards.addAll(getEmptyDeck())
        }
    }

    fun size(): Int = cards.size

    private fun decksInShoe(): Int = (cards.size/52)

    fun isEmpty(): Boolean = cards.isEmpty()

    /**
     * Removes the first card in the shoe and returns it.
     * @return: The Card that was drawn from the shoe.
     * @throws NoSuchElementException: When calling this method while the shoe is empty.
     */
    fun draw(): Card{
        if(isEmpty()){
            throw NoSuchElementException("Attempted to draw while the shoe is empty.")
        }
        return cards.removeAt(0)
    }

}