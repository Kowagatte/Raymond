package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card

class DiscardTray{

    private val cards: MutableList<Card> = mutableListOf()

    fun insert(card: Card){
        cards.add(card)
    }

    fun size() = cards.size

}