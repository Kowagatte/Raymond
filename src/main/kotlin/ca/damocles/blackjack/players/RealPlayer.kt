package ca.damocles.blackjack.players

import ca.damocles.blackjack.game.Player
import ca.damocles.blackjack.game.PlayingDecision
import ca.damocles.blackjack.io.IOAccess

class RealPlayer: Player() {

    /**
     * This method will gain the playing decision of any given player, including the dealer.
     * Whenever the table needs to know the players decision it will use this method to obtain it.
     * @return: the Players playing decision
     */
    override fun getPlayingDecision(): PlayingDecision {
        IOAccess.io.prompt("Your decision? (hit, stand, split, double): ")
        return PlayingDecision.valueOf(IOAccess.io.input().toUpperCase())
    }

}