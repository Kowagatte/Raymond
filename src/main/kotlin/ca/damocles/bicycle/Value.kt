package ca.damocles.bicycle

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
    ACE("Ace", "A", listOf(1, 11)),
    CUT("", "", listOf());
}