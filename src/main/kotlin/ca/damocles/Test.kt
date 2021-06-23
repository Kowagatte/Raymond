package ca.damocles

import ca.damocles.blackjack.io.IOAccess

fun main(){
    IOAccess.io.prompt("Test")
    val test = IOAccess.io.input()
    IOAccess.io.prompt("You wrote: $test")
}