extends Node

enum FTStates {TIMER_INPUT, FLIPPING, ASKING, RESPONSE}

# Static after intialization 
var timer_limit = 1000
var card_sprite: Sprite
var label: Label
var timer: Timer
var linedit: LineEdit

# Dynamic values
var state = FTStates.TIMER_INPUT
var showing = Card.new(Card.Suits.SPADE, Card.Values.ACE)
var deck = []
var taken: Card

# Called when the node enters the scene tree for the first time.
func _ready():
	label = get_node("Label") as Label
	linedit = get_node("LineEdit") as LineEdit
	card_sprite = get_node("card") as Sprite
	linedit.connect("text_entered", self, "input")
	
	# Construct a deck of cards and randomly shuffle.
	for x in range(1, Card.Suits.size()):
		for y in range(1, Card.Values.size()):
			deck.append(Card.new(x, y))
	
	randomize()
	deck.shuffle()
	
	taken = deck.pop_front()
	
	label.text = "How fast should we flip through the deck?\n(Input is in card/second)"
	var atlas = card_sprite.texture as AtlasTexture
	atlas.set_region(Rect2(0, 0, 35, 47))
	
func input(inp):
	if state == FTStates.TIMER_INPUT:
		start_timer(float(inp))
		state = FTStates.FLIPPING
		linedit.text = ""
		label.text = ""
	
	if state == FTStates.ASKING:
		#TODO get response and prompt if correct
		state = FTStates.RESPONSE
		if linedit.text == str(taken.hilo_value()*-1):
			label.text = "Correct!"
		else:
			label.text = "Wrong, The correct count was "+str(taken.hilo_value()*-1)
		pass

func start_timer(delay):
	timer = Timer.new()
	timer.set_wait_time(delay)
	timer.set_one_shot(false)
	timer.connect("timeout", self, "flip")
	add_child(timer)
	timer.start()

# Takes a card off the top of the deck and shows it.
func flip():
	showing = deck.pop_front() as Card
	var atlas = card_sprite.texture as AtlasTexture
	atlas.set_region(showing.getRegion())
	#print(deck)
	if deck.empty():
		state = FTStates.ASKING
		label.text = "What is the count?"
		timer.stop()
