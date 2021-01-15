package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import java.util.*

/**
 * Abstract class Player,
 * Represents the player that sits at the blackjack dealer, the dealer or "house" is a player
 * also just with limited playing decisions.
 */
abstract class Player(val uuid: UUID = UUID.randomUUID(), val hands: MutableList<MutableList<Card>> = mutableListOf(), var currentHandNumber: Int = 0) {

    /**
     * Gets a reference to a list of cards representing the currently active hand the player has.
     * @return: a mutable list of cards
     */
    fun getActiveHand(): MutableList<Card>{
        return hands[currentHandNumber]
    }

    /**
     * Gets the number of hands the Player currently has.
     * @return: the size of hands, which is the number of hands the player currently has.
     */
    fun getNumberOfHands(): Int = hands.size

    /**
     * This method will gain the playing decision of any given player, including the dealer.
     * Whenever the table needs to know the players decision it will use this method to obtain it.
     * @return: the Players playing decision
     */
    abstract fun getPlayingDecision(): PlayingDecision

}

enum class PlayingDecision{
    HIT, STAND, DOUBLE, SPLIT;
}