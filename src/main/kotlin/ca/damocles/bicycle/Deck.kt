package ca.damocles.bicycle

import ca.damocles.collections.Shuffleable
import kotlin.random.Random

/**
 * A generic 52-card deck of cards.
 */
class Deck: Shuffleable<Card> {

    override val cards: MutableList<Card> = mutableListOf()

    /**
     * Fill the 52 card deck with cards.
     */
    init{
        for(suit in Suit.values()){
            for(value in Value.values()){
                cards.add(Card(suit, value))
            }
        }
    }

    /**
     * Cards are drawn from the top of the deck, aka index 0.
     * This method removes the card at index 0.
     * @returns: the card removed from the deck.
     */
    fun draw(): Card{
        val drawnCard = cards[0]
        cards.removeAt(0)
        return drawnCard
    }

    /**
     * @returns: current size of the deck.
     */
    fun size(): Int = cards.size

    /**
     * @returns: Formatted string representing the list of cards.
     */
    override fun toString(): String{
        return cards.toString()
    }

}