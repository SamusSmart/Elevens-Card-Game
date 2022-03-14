import java.util.Random;

public class Deck {

    public static final String[] RANKS = {"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    Card cardArray[];
    int headIdx = -1;
    int size;

    public Deck(int maxSize) {
        size = maxSize;
        cardArray = new Card[maxSize];
    }

    public void createDeck(){
        for(int i = 0; i < RANKS.length; i++) {
            for(int j = 0; j < SUITS.length; j++) {
                push(new Card(RANKS[i], SUITS[j]));
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();

        for(int i = 0; i < cardArray.length; i++){
            Card tempSlot = cardArray[i];
            int randGen = rand.nextInt(size); // Replacing hard-coded numbers with size variables

            cardArray[i] = cardArray[randGen];
            cardArray[randGen] = tempSlot;
        }
    }

    public Card pop(){
        if(isEmpty()) {
                return null;
            } else {
                headIdx --;
                return cardArray[headIdx + 1];
            }
    }

    public void push(Card card){
        headIdx ++;
        cardArray[headIdx] = card;
    }

    public Card peek() {
        return cardArray[headIdx];
    }

    public boolean isEmpty() {
        if(headIdx < 0) {
            return true;
        } return false;
    }

    public int getMaxSize() {
        return cardArray.length;
    }


    public String toString() { // toString method to return the deck in proper form
        return peek().getRank() + " of " + peek().getSuit();
    }

}
