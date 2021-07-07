package ca.damocles.bicycle

/**
 * Basic playing card implementation.
 */
open class Card(val suit: Suit, val value: Value){

    /**
     * Compares if the Suit and Value of the given card matches.
     * @param other: the object to be compared to the Card.
     * @return: True if the given Card has the same Suit and Value, false otherwise.
     */
    override fun equals(other: Any?): Boolean {
        if(other != null){
            if(other is Card){
                if(other.suit == suit && other.value == value){
                    return true
                }
            }
        }
        return false
    }

    /**
     * Compares if the given Card has the same suit.
     * @param other: The Card object being compared.
     * @return: True if the suits are the same. False otherwise.
     */
    fun equalSuits(other: Card) = other.suit == suit

    fun isAce(): Boolean = equalValue(Value.ACE)

    /**
     * Compares if the given card has the same value.
     * @param other: the Card object being compared.
     * @return: True if the values match. False otherwise.
     */
    fun equalValue(other: Value): Boolean{
        /*
        For example a 'King' and a 'Jack' have equal value, although they are not the same Value.
         */
        return other == value
    }

    fun unicodeRepresentation(): String = "1f0${suit.complexRepresentation}${value.complexRepresentation}"

    fun complexString(): String = String(Character.toChars(unicodeRepresentation().toInt(16)))

    override fun toString(): String = "${suit.unicodeValue}${value.simpleRepresentation}"

    override fun hashCode(): Int {
        var result = suit.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

}