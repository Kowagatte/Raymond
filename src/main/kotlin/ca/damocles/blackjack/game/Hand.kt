package ca.damocles.blackjack.game

import ca.damocles.bicycle.Card
import ca.damocles.bicycle.Suit
import ca.damocles.bicycle.Value

class Hand(val cards: MutableList<Card> = mutableListOf()) {

    fun getNonAceValue(): Int{
        var value: Int = 0
        for(card in cards){
            if(!card.isAce())
                value += card.value.values[0]
        }
        return value
    }

    fun getValue(): Pair<Int, Boolean>{

        return Pair(0, false)
    }

    fun containsAce(): Boolean{
        for(card in cards){
            if(card.isAce())
                return true
        }
        return false
    }

}

fun main(){
    val hand: Hand = Hand(mutableListOf(
        Card(Suit.CLUB, Value.ACE),
        Card(Suit.DIAMOND, Value.TEN),
        Card(Suit.HEART, Value.FOUR)
    ))
    println(hand.getNonAceValue())
}