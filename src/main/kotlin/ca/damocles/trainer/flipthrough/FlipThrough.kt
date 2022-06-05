package ca.damocles.trainer.flipthrough

import ca.damocles.bicycle.MultiDeck
import ca.damocles.blackjack.io.GraphicsIO
import ca.damocles.blackjack.io.IOAccess
import ca.damocles.blackjack.io.IOForm
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main(){

    val io: IOForm = GraphicsIO()

    io.print("How many decks to flip through?")
    //val numOfDecks: Int = IOAccess.io.input().toInt()
    val numOfDecks = 1

    io.print("How fast should we flip through? (in millis)")
    //val speed: Long = io.input().toLong()
    val speed = 100L

    val decks = MultiDeck(numOfDecks)

    decks.shuffle()

    val missingCard = decks.draw()

    val finalCount: Int = missingCard.value.hiloValue * -1

    //IOAccess.io.prompt("Starting to flip through")
    thread{
        var count = 0
        while(true){
            if(decks.isEmpty())
                break
            val card = decks.draw()
            count += card.value.hiloValue
            io.print(card)
            sleep(speed)
        }
        io.print("What is the count?")
        io.print("Your answer: ${io.input()} | Missing Card: $missingCard | Correct count: $finalCount")
    }
}