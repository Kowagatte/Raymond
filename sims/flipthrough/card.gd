extends Node

class_name Card

enum Suits {NONE, HEART, DIAMOND, CLUB, SPADE}
enum Values {NONE, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

const pv =  ['', 'A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
const ps = ['', '♥', '♦', '♣', '♠']

var suit: int
var value: int

func _init(starting_suit:int = Suits.NONE, starting_value:int = Values.NONE):
	suit = starting_suit
	value = starting_value
	
func _to_string():
	return "{" + str(ps[suit])+str(pv[value])+"}"
