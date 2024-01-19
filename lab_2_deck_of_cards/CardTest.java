package CS_145_Shared.lab_2_deck_of_cards;

public class CardTest {
    public static void main(String[] args){
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();

        for(int i = 1; i <= 52; i++){
            // deal and display a card
            System.out.printf("%-19s", myDeckOfCards.dealCard());

            if (i % 4 == 0) { //output a newline after every fourth card
                System.out.println();
            }
        }
    }
    
}