extends Node2D

var flipthrough_button: Button
var blackjack_button: Button

# Called when the node enters the scene tree for the first time.
func _ready():
	flipthrough_button = get_node("Label/FlipThrough") as Button
	blackjack_button = get_node("Label/Blackjack") as Button
	
	flipthrough_button.connect("button_up", self, "switch_flip")
	blackjack_button.connect("button_up", self, "switch_blackjack")

func switch_blackjack():
	get_tree().change_scene("res://sims/blackjack/BlackJack.tscn")
	#print("blackjack")

func switch_flip():
	get_tree().change_scene("res://sims/flipthrough/FlipThrough.tscn")
	#print("flipthrough")

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
