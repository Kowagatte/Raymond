package ca.damocles.blackjack.io

/**
 * Adaptable IOForm
 * any IO system should implement this interface.
 */
interface IOForm {

    /**
     * Prints message to the user interface
     * @param message: the message to send to the user.
     */
    fun print(message: Any)

    /**
     * Receives message from the user interface
     * @return: the message received from the user interface.
     */
    fun input(): String

}