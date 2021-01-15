package ca.damocles.blackjack.players

import ca.damocles.bicycle.Card
import ca.damocles.blackjack.game.Player
import ca.damocles.blackjack.game.PlayingDecision

class Dealer: Player() {

    /**
     * This method will gain the playing decision of any given player, including the dealer.
     * Whenever the table needs to know the players decision it will use this method to obtain it.
     * @return: the Players playing decision
     */
    override fun getPlayingDecision(): PlayingDecision {
        TODO("Not yet implemented")
    }

}