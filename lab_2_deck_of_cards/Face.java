package CS_145_Shared.lab_2_deck_of_cards;

public enum Face {
    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13);

    //A unique value for each card Ace=1, two=2,..., king=13
    private final int value;
    Face(int value){
        this.value = value;
    }
    public int getValue(){
        return(this.value);
    }
}
