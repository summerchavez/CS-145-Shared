package CS_145_Shared.lab_2_deck_of_cards;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DeckOfCards {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;

    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private int currentCard = 0;

    public DeckOfCards() {
        Face[] faces = Face.values();
        Suit[] suits = Suit.values();

        for (int count = 0; count < deck.length; count++) {
            deck[count] =
                new Card(faces[count % 13], suits[count / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;

        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length) {
            return(deck[currentCard++]);
        }
        else {
            return null;
        }
    }

    public static boolean hasPair(Card[] hand) {
        Map<Face, Long> faceCount = Arrays.stream(hand)
                .collect(Collectors.groupingBy(Card::getFace, Collectors.counting()));

        return faceCount.containsValue(2L);
    }

    public static boolean hasTwoPairs(Card[] hand) {
        Map<Face, Long> faceCount = Arrays.stream(hand)
                .collect(Collectors.groupingBy(Card::getFace, Collectors.counting()));

        long pairsCount = faceCount.values().stream().filter(count -> count == 2).count();
        return pairsCount == 2;
    }

    public static boolean hasThreeOfAKind(Card[] hand) {
        Map<Face, Long> faceCount = Arrays.stream(hand)
                .collect(Collectors.groupingBy(Card::getFace, Collectors.counting()));

        return faceCount.containsValue(3L);
    }

    public static boolean hasFourOfAKind(Card[] hand) {
        Map<Face, Long> faceCount = Arrays.stream(hand)
                .collect(Collectors.groupingBy(Card::getFace, Collectors.counting()));

        return faceCount.containsValue(4L);
    }

    public static boolean hasFlush(Card[] hand) {
        Suit firstCardSuit = hand[0].getSuit();
        return Arrays.stream(hand).allMatch(card -> card.getSuit() == firstCardSuit);
    }

    public static boolean hasStraight(Card[] hand) {
        Arrays.sort(hand);
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i + 1].getFace().ordinal() - hand[i].getFace().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasFullHouse(Card[] hand) {
        Map<Face, Long> faceCount = Arrays.stream(hand)
                .collect(Collectors.groupingBy(Card::getFace, Collectors.counting()));

        return faceCount.containsValue(3L) && faceCount.containsValue(2L);
    }
}

