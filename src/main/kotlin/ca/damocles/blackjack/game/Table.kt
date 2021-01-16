package ca.damocles.blackjack.game

import ca.damocles.blackjack.players.Dealer

class Table(numOfSeats: Int = 5){

    /**
     * Array of all players at the table,
     * Each array index represents a seat at the table.
     * If the value at the given array index is null the seat is empty.
     */
    val seats: Array<Player?> = arrayOfNulls<Player>(numOfSeats+1)

    init{
        seats[0] = Dealer()
    }

    /**
     * Seats a player at the given seat number.
     * @param seatNumber: the seat number (array index) the player will be seated at.
     * @param player: the player to be seated at the table.
     * @return: if the operation was successful or not.
     */
    fun sitPlayer(seatNumber: Int, player: Player): Boolean{1
        //Do not seat player in invalid seat
        if(seatNumber < 1 || seatNumber > seats.size){
            return false
        }

        //Do not seat player in
        if(seats[seatNumber] != null){
            return false
        }

        //If the player is already seated at the table do not seat them again.
        for(player in seats){
            if(player != null){
                if(player.uuid == player.uuid){
                    return false
                }
            }
        }

        seats[seatNumber] = player
        return true
    }

    /**
     * Removes or backs off a player from the table at the specific seat.
     * @param: seat number of the player to be removed.
     * @return: if the operation was successful or not.
     */
    fun standUpPlayer(seatNumber: Int): Boolean{
        //Do not seat player in invalid seat
        if(seatNumber < 1 || seatNumber > seats.size){
            return false
        }
        //cannot remove a
        if(seats[seatNumber] == null){
            return false
        }
        seats[seatNumber] = null
        return true
    }


}