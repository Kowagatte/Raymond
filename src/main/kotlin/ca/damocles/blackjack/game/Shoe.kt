package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import ca.damocles.collections.Shuffleable
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value
import ca.damocles.bicycle.getEmptyDeck

/**
 * Collection - Shoe
 *
 * The "Shoe" is the container that holds all the decks being pulled from.
 * This can contain any number of decks including 1. The cut card is placed at any
 * variable location of the Shoe this is up to the dealer/house.
 *
 * @param numberOfDecks: the number of decks being played in the shoe.
 * @param cutLocation: the location of the cutcard, approximate, 0 for the front, 0.5 for the middle 1 for the end.
 */
class Shoe(numberOfDecks: Int, cutLocation: Float): Shuffleable<Card> {

    // All the cards in the game
    override val cards: MutableList<Card> = mutableListOf()

    // On initialize
    init{
        // Add all cards from each deck into the shoe,
        for(x in 1..numberOfDecks){
            cards.addAll(getEmptyDeck())
        }
        // TODO add cutcard here?
        // ***Note*** cutcard location varies from shoe-to-shoe based on the dealer.
    }

    fun size(): Int = cards.size

    private fun sizeAsDecks(): Double = cards.size / 52.0

    fun isEmpty(): Boolean = cards.isEmpty()

    /**
     * Removes the first card in the shoe and returns it.
     * @return: The Card that was drawn from the shoe.
     * @throws NoSuchElementException: When calling this method while the shoe is empty.
     */
    fun draw(): Card{
        if(isEmpty()) throw NoSuchElementException("Attempted to draw while the shoe is empty.")
        return cards.removeAt(0)
    }

}