package ca.damocles.bicycle

enum class Value(val formattedName: String, val simpleRepresentation: String, val complexRepresentation: String, val values: List<Int>, val hiloValue: Int){
    KING("King", "K", "e", listOf(10), -1),
    QUEEN("Queen", "Q","d", listOf(10), -1),
    JACK("Jack", "J","b", listOf(10), -1),
    TEN("Ten", "10","a", listOf(10), -1),
    NINE("Nine", "9","9", listOf(9), 0),
    EIGHT("Eight", "8","8", listOf(8), 0),
    SEVEN("Seven", "7","7", listOf(7), 0),
    SIX("Six", "6","6", listOf(6), 1),
    FIVE("Five", "5","5", listOf(5), 1),
    FOUR("Four", "4","4", listOf(4), 1),
    THREE("Three", "3","3", listOf(3), 1),
    TWO("Two", "2","2", listOf(2), 1),
    ACE("Ace", "A","1", listOf(1, 11), -1),
    CUT("", "","", listOf(), 0);
}