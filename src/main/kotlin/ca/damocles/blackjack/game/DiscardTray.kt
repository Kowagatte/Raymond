package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card

/**
 * Collection - DiscardTray
 *
 * Class representing the discard tray at a blackjack table.
 * This contains the cards removed from play at the end of each hand dealt.
 * Cards in this container should never be visible to players or the dealer during the
 * game. One card is always burned here at the start of the game.
 */
class DiscardTray{

    private val cards: MutableList<Card> = mutableListOf()

    // All cards in play are inserted here after each round of play.
    fun insert(card: Card){
        cards.add(card)
    }

    // Clears the discard tray, this is done during the hand directly after the cut card comes out.
    fun clear() = cards.clear()

    fun size() = cards.size

    /**
     * Size represented in regard to how many decks this total size makes up.
     * Example: a discard tray of size 104 would return 2.0d
     * because it has 2 standard decks worth of cards contained in it.
     */
    fun sizeAsDecks(): Double = cards.size / 52.0

}