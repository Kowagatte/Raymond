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
        val valueWithoutAces = getNonAceValue()
        val numberOfAces = getNumberOfAces()

        return if(numberOfAces > 0){
            if(numberOfAces == 1){
                if(valueWithoutAces+11 <= 21){

                }
            }else{

            }
            Pair(0, true)
        }else{
            Pair(valueWithoutAces, false)
        }
    }

    fun getNumberOfAces(): Int{
        val i = 0
        for(card in cards){
            if(card.isAce())
                i.inc()
        }
        return i
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