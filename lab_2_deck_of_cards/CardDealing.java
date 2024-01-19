package CS_145_Shared.lab_2_deck_of_cards;
import java.util.Arrays;

public class CardDealing{
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        // Deal two poker hands
        Card[] hand1 = dealPokerHand(deck);
        Card[] hand2 = dealPokerHand(deck);

        // Print the hands
        System.out.println("Hand 1: " + Arrays.toString(hand1));
        System.out.println("Hand 2: " + Arrays.toString(hand2));

        // Evaluate and compare hands
        int result = compareHands(hand1, hand2);

        // Print the result
        if (result > 0) {
            System.out.println("Hand 1 is the better hand");
        } else if (result < 0) {
            System.out.println("Hand 2 is the better hand");
        } else {
            System.out.println("Hand 1 and hand 2 are the same");
        }
    }

    private static Card[] dealPokerHand(DeckOfCards deck) {
        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = deck.dealCard();
        }
        return hand;
    }

    private static int compareHands(Card[] hand1, Card[] hand2) {
        // Evaluate hands
        int rank1 = evaluateHand(hand1);
        int rank2 = evaluateHand(hand2);

        // Compare ranks
        return Integer.compare(rank1, rank2);
    }

    private static int evaluateHand(Card[] hand) {
        if (DeckOfCards.hasStraight(hand) && DeckOfCards.hasFlush(hand)) {
            return 8; // Straight Flush
        } else if (DeckOfCards.hasFourOfAKind(hand)) {
            return 7; // Four of a Kind
        } else if (DeckOfCards.hasFullHouse(hand)) {
            return 6; // Full House
        } else if (DeckOfCards.hasFlush(hand)) {
            return 5; // Flush
        } else if (DeckOfCards.hasStraight(hand)) {
            return 4; // Straight
        } else if (DeckOfCards.hasThreeOfAKind(hand)) {
            return 3; // Three of a Kind
        } else if (DeckOfCards.hasTwoPairs(hand)) {
            return 2; // Two Pairs
        } else if (DeckOfCards.hasPair(hand)) {
            return 1; // One Pair
        } else {
            return 0; // High Card
        }
    }
}