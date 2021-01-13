package ca.damocles.blackjack.io

class ConsoleIO: IOForm {

    override fun prompt(message: Any) {
        println(message)
    }

    override fun input(): String {
        return readLine().toString()
    }

}