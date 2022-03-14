import java.util.Scanner;

public class Game {

    public static void main(String[] args){

       Deck mainDeck = new Deck(52);
       mainDeck.createDeck();
       mainDeck.shuffle();

       Card[] hand = new Card[9];

       // Moving cards from the main deck to the hand
       for(int i = 0; i < hand.length; i++) {
            hand[i] = mainDeck.pop();
       }

       boolean handEmpty = false;
       while(!handEmpty){
                for(int i = 0; i < hand.length; i++) {
                    if(hand[i] != null) {
                        System.out.println(i + ". " + hand[i]);
                    }
                    else{
                        System.out.println("null");
                    }
                }

                // Counter for the JQK removal
                int counter = 0;

                for(int i = 0; i < hand.length; i++) {
                    if (hand[i] != null && Integer.parseInt(hand[i].getRank()) >= 11)
                        counter++;
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Select index positions: ");

                // Taking two user inputs and adding them together for a total card value
                int card1 = scanner.nextInt();
                int card2 = scanner.nextInt();
                int cardSum = hand[card1].getRankValue() + hand[card2].getRankValue();


                // Removal of legal addition of two cards
                if(cardSum == 11) {
                    hand[card1] = mainDeck.pop();
                    hand[card2] = mainDeck.pop();

                    System.out.println("Legal addition found.");
                }

                // Checking two cards are either J, Q, or K
                else if ((cardSum >= 23) && (hand[card1].getRankValue() != hand[card2].getRankValue()) && counter >= 3) {
                    int card3 = scanner.nextInt();
                    cardSum += hand[card3].getRankValue();

                    // Removing JQK cards
                    if (cardSum == 36) {
                        hand[card1] = mainDeck.pop();
                        hand[card2] = mainDeck.pop();
                        hand[card3] = mainDeck.pop();
                        System.out.println("Legal addition found.");
                    }

                    else System.out.println("No legal addition.");
                }

                else System.out.println("No legal addition.");

           // Checks for empty hand for completion
           int handCount = 0;

           for(int i = 0; i < hand.length; i++) {
               if(hand[i] == null){
                   handCount++;
               }
           }

           if(handCount == hand.length){
               handEmpty = true;
           }
       }


       while(handEmpty){
           System.out.println("The hand is now empty, congratulations!");
           break;
       }
    }
}
