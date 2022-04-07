package ca.damocles.bicycle

enum class Suit(val formattedName: String, val charRepresentation: Char, val unicodeValue: String, val complexRepresentation: String){
    SPADE("Spade", 's', "\u2660", "a"),
    CLUB("Club", 'c', "\u2663", "d"),
    HEART("Heart", 'h', "\u2665", "b"),
    DIAMOND("Diamond", 'd', "\u2666", "c"),
    CUT("Cut Card", 'X', "Cut Card", ""),
    EMPTY("Empty Card", ' ', "Empty Card", "");
}

val validSuits: List<Suit> = listOf(Suit.SPADE, Suit.CLUB, Suit.HEART, Suit.DIAMOND)