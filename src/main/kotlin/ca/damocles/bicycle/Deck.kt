package ca.damocles.bicycle

import ca.damocles.collections.Shuffleable
import kotlin.random.Random

/**
 * A generic 52-card deck of cards.
 */
open class Deck: Shuffleable<Card> {

    companion object{

        fun generateCards(i: Int): MutableList<Card>{
            val cards: MutableList<Card> = mutableListOf()
            for(x in 1..i){

                for(suit in validSuits){
                    for(value in validValues){
                        cards.add(
                            Card(suit,
                                value)
                        )
                    }
                }
            }

            return cards
        }

    }

    final override var cards: MutableList<Card> = generateCards(1)

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

    fun isEmpty(): Boolean = cards.isEmpty()

    /**
     * @returns: Formatted string representing the list of cards.
     */
    override fun toString(): String{
        return cards.toString()
    }

}

class MultiDeck(numOfDecks: Int): Deck() {

    init{
        cards = generateCards(numOfDecks)
    }

}

fun generateSingleDeck(): MutableList<Card> = Deck().cards

fun generateDecks(i: Int): MutableList<Card> {
    val cards: MutableList<Card> = mutableListOf()
    for(x in 1..i)
        cards.addAll(Deck().cards)
    return cards
}

@Deprecated("Use generateDecks# instead")
fun getEmptyDeck(): MutableList<Card>{
    val cards: MutableList<Card> = mutableListOf()
    for(suit in Suit.values().dropLast(1)){
        for(value in Value.values().dropLast(1)){
            cards.add(Card(suit, value))
        }
    }
    return cards
}