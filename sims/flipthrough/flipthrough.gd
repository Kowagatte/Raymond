extends Node

# Declare member variables here. Examples:
# var a = 2
# var b = "text"

var showing = Card.new(Card.Suits.SPADE, Card.Values.ACE)

var deck = []

# Called when the node enters the scene tree for the first time.
func _ready():
	
	for x in range(1, Card.Suits.size()):
		for y in range(1, Card.Values.size()):
			deck.append(Card.new(x, y))
	
	randomize()
	deck.shuffle()
	
	
	print(deck)
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
