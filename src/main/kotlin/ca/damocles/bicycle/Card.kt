package ca.damocles.bicycle

/**
 * Basic playing card implementation.
 */
data class Card(val suit: Suit, val value: Value){
    override fun toString(): String =  "${suit.unicodeValue}${value.simpleRepresentation}"
}

enum class Suit(val formattedName: String, val charRepresentation: Char, val unicodeValue: String){
    SPADE("Spade", 's', "\u2660"),
    CLUB("Club", 'c', "\u2663"),
    HEART("Heart", 'h', "\u2665"),
    DIAMOND("Diamond", 'd', "\u2666");
}

enum class Value(val formattedName: String, val simpleRepresentation: String, val values: List<Int>){
    KING("King", "K", listOf(10)),
    QUEEN("Queen", "Q", listOf(10)),
    JACK("Jack", "J", listOf(10)),
    TEN("Ten", "10", listOf(10)),
    NINE("Nine", "9", listOf(9)),
    EIGHT("Eight", "8", listOf(8)),
    SEVEN("Seven", "7", listOf(7)),
    SIX("Six", "6", listOf(6)),
    FIVE("Five", "5", listOf(5)),
    FOUR("Four", "4", listOf(4)),
    THREE("Three", "3", listOf(3)),
    TWO("Two", "2", listOf(2)),
    ACE("Ace", "A", listOf(1, 11));
}