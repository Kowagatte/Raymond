package ca.damocles.blackjack.io

class EmptyIO: IOForm {

    override fun print(message: Any) {}

    override fun input(): String = ""
}