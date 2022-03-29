package ca.damocles.trainer

import ca.damocles.blackjack.game.Shoe
import ca.damocles.blackjack.io.IOAccess
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main(){

    IOAccess.io.prompt("How many decks to flip through?")
    val numOfDecks: Int = IOAccess.io.input().toInt()

    IOAccess.io.prompt("How fast should we flip through? (in millis)")
    val speed: Long = IOAccess.io.input().toLong()

    val decks = Shoe(numOfDecks, 1f)
    decks.shuffle()

    val missingCard = decks.draw()

    val finalCount: Int = missingCard.value.hiloValue * -1

    IOAccess.io.prompt("Starting to flip through")
    thread{
        var count = 0
        while(true){
            if(decks.isEmpty())
                break
            val card = decks.draw()
            count += card.value.hiloValue
            IOAccess.io.prompt(card.complexString())
            sleep(speed)
        }
        IOAccess.io.prompt("What is the count?")
        IOAccess.io.prompt("Your answer: ${IOAccess.io.input()} | Missing Card: ${missingCard.complexString()} | Correct count: $finalCount")
    }
}