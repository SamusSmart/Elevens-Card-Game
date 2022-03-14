public class TestClass {

    static Deck testDeck = new Deck(52);

    private static void testCards(){
        Card cardTest1 = new Card("2","Diamonds");
        Card cardTest2 = new Card("10","Clubs");
        Card cardTest3 = new Card("3","Spades");

        System.out.println(cardTest1);
        System.out.println(cardTest2);
        System.out.println(cardTest3);

        System.out.println("\n");

        System.out.println("Card 1 Rank: " + cardTest1.getRankValue());
        System.out.println("Card 2 Rank: " + cardTest2.getRankValue());
        System.out.println("Card 3 Rank: " + cardTest3.getRankValue());

        System.out.println("\n");

        System.out.println("Card 1 Suit: " + cardTest1.getSuit());
        System.out.println("Card 2 Suit: " + cardTest2.getSuit());
        System.out.println("Card 3 Suit: " + cardTest3.getSuit());

    }

    public static void main(String[] args) {
        testCards();
        testDeck.createDeck();

        System.out.println("\n");

        for (int i = 0; i < 3; i++){
            testDeck.shuffle();
            System.out.println(testDeck.toString());
        }
    }
}