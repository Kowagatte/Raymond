package ca.damocles

import ca.damocles.blackjack.io.IOAccess

fun main(){
    IOAccess.io.print("Test")
    val test = IOAccess.io.input()
    IOAccess.io.print("You wrote: $test")
}