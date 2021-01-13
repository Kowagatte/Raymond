package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card

/**
 * Abstract class Player,
 * Represents the player that sits at the blackjack dealer, the dealer or "house" is a player
 * also just with limited playing decisions.
 */
abstract class Player {

    /**
     * Gets a reference to a list of cards representing the currently active hand the player has.
     * @return: a mutable list of cards
     */
    abstract fun getActiveHand(): MutableList<Card>

    /**
     * Gets a reference to a list of hands the player has,
     * can have multiple hands because a player can split their hands.
     * @return: a mutable list of mutable lists of cards
     */
    abstract fun getHands(): MutableList<MutableList<Card>>

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