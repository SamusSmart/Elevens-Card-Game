public class Card {

    private final String RANK, SUIT;

    public Card(String RANKS, String SUITS) {
       RANK = RANKS;
       SUIT = SUITS;
    }

    public String getRank() {
        return RANK;
    }

    public String getSuit() {
        return SUIT;
    }

    public int getRankValue() {
        return Integer.parseInt(RANK);
    }

    public String toString() { // toString method to return the card in proper form
        return getRank() + " of " + getSuit();
    }

    public int compareTo(Card otherCard) {
        if(this.getRankValue() > otherCard.getRankValue()) return 1;
        else if (this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;
    }
}
