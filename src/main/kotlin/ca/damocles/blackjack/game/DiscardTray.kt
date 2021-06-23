package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card

/**
 * Class representing the discard tray
 * Holds which cards have been discarded from the game.
 */
class DiscardTray{

    private val cards: MutableList<Card> = mutableListOf()

    fun insert(card: Card){
        cards.add(card)
    }

    fun size() = cards.size

}