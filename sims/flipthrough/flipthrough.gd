extends Node

enum FTStates {TIMER_INPUT, FLIPPING, ASKING, RESPONSE}

# Static after intialization 
var timer_limit = 1000
var card_sprite
var timer
var linedit

# Dynamic values
var state = FTStates.TIMER_INPUT
var showing = Card.new(Card.Suits.SPADE, Card.Values.ACE)
var deck = []

# Called when the node enters the scene tree for the first time.
func _ready():
	linedit = get_node("LineEdit") as LineEdit
	card_sprite = get_node("card") as Sprite
	linedit.connect("text_entered", self, "input")
	
	# Construct a deck of cards and randomly shuffle.
	for x in range(1, Card.Suits.size()):
		for y in range(1, Card.Values.size()):
			deck.append(Card.new(x, y))
	
	randomize()
	deck.shuffle()
	
func input(inp):
	if state == FTStates.TIMER_INPUT:
		start_timer(float(inp))
		state = FTStates.FLIPPING
	
	if state == FTStates.ASKING:
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
	var texture = load(showing.getResourcePath())
	card_sprite.texture = texture
	#print(deck)
	if deck.empty():
		timer.stop()

var previous_state = null
func _process(delta):
	match(state):
		FTStates.TIMER_INPUT:
			pass
		FTStates.FLIPPING:
			pass
		FTStates.ASKING:
			pass
		FTStates.RESPONSE:
			pass
