package ca.damocles.bicycle

enum class Suit(val formattedName: String, val charRepresentation: Char, val unicodeValue: String){
    SPADE("Spade", 's', "\u2660"),
    CLUB("Club", 'c', "\u2663"),
    HEART("Heart", 'h', "\u2665"),
    DIAMOND("Diamond", 'd', "\u2666"),
    CUT("Cut Card", 'X', "Cut Card");
}