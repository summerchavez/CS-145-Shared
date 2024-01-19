package CS_145_Shared.lab_2_deck_of_cards;

public class Card {
    private final Face face;
    private final Suit suit;
    
    public Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;
    }

    public Face getFace(){
        return(this.face);
    }
    public Suit getSuit(){
        return(this.suit);
    }

    //Override the default toString
    public String toString(){
        return(this.face + " of " + this.suit);
    }
}
