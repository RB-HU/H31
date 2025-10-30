import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
  public class BlackjackSolitaire {
        private static int GRID_SIZE = 20;
        private static int SCORED_SPOTS = 16;
        private static int DISCARD_SPOTS = 4;
        private Card[] card;
        private Deck deck;
        private Scanner scanner;
        private int placedCards=0;
        private int discardsUsed=0;

        public BlackjackSolitaire() {
            card = new Card[GRID_SIZE + 1];
            deck = new Deck();
            scanner = new Scanner(System.in);
        }

        public void play() {
            System.out.println("Blackjack Solitaire");
            while(placedCards < SCORED_SPOTS) {
                display();
                Card currentCard = deck.dealCard();
                if(currentCard == null) {
                    System.out.println("No more cards in deck!");
                    break;
                }
                System.out.println("Current card: " + currentCard);
                System.out.print("Enter position (1-16 for grid, 17-20 for discard): ");
                int position = getValidPosition();
                placeCard(position, currentCard);
            }

            int score = calculateScore();
            System.out.println("Game over! You scored " + score + " points.");
        }

        private void display() {
            for(int i = 1; i <= GRID_SIZE; i++) {
                if(i <= 16) {
                    if(i!=11 && i != 14) {
                        if (card[i] != null) {
                            System.out.print(card[i] + "\t");
                        }
                        else {
                            System.out.print(i + "\t");
                        }
                    }
                    else{
                        if (card[i] != null) {
                            System.out.print("\t" + card[i] + "\t");
                        }
                        else {
                            System.out.print("\t" + i + "\t");
                        }
                    }

                    if(i == 5 || i == 10 || i == 13) System.out.println();
                }
            }
            System.out.println("\nDiscards remaining: " + (DISCARD_SPOTS - discardsUsed));
        }

        private int getValidPosition() {
            while (true) {
                int position = scanner.nextInt();
                if (position < 1 || position > GRID_SIZE) {
                    System.out.println("Invalid position! Please enter a number between 1 and 20.");
                    continue;
                }
                if (card[position] != null) {
                    System.out.println("Position " + position + " is already occupied!");
                    continue;
                }
                if (position > 16 && discardsUsed >= DISCARD_SPOTS) {
                    System.out.println("No more discards available!");
                    continue;
                }
                return position;

            }
        }

        private void placeCard(int position, Card newcard) {
            card[position] = newcard;
            if(position > 16) {
                discardsUsed++;
            }
            else {
                placedCards++;
            }
        }

        private int calculateScore() {
            int totalScore = 0;
            int[][] row = {
                    {1,2,3,4,5},
                    {6,7,8,9,10},
                    {11,12,13},
                    {14,15,16}
            };
            int[][] col = {
                    {1,6},
                    {2,7,11,14},
                    {3,8,12,15},
                    {4,9,13,16},
                    {5,10}
            };
            return totalScore;
        }

        private int scoreHand(int[] positions) {
            List<Card> hand = new ArrayList<>();
            for(int i=0; i<positions.length;i++) {
                int pos=positions[i];
                if(card[pos] != null) {
                    hand.add(card[pos])
                }
            }

            int bestScore = calculateBestHandValue(hand);
            return getPointsForValue(bestScore, hand.size());
        }

        private int calculateBestHandValue(List<Card> hand) {
            int aceCount = 0;
            int baseValue = 0;
            for(int i = 0; i < hand.size(); i++) {
                Card card = hand.get(i);
                if(card.getRank().equals("A")) {
                    aceCount++;
                }
                else {
                    baseValue += card.getValue();
                }
            }

            int MinValue = baseValue + aceCount;
            for(int i = 0; i < aceCount; i++) {
                if (MinValue > 21 || MinValue+10>21) {
                    break;
                }
                else {
                    MinValue += 10;
                }

            }

            return MinValue;
        }

        private int getPointsForValue(int value, int handsize) {
            if(value > 21)
                return 0;
            if(value == 21) {
                if (handsize==2){
                    return 10;
                }
                else{
                    return 7;
                }

            }
            switch(value) {
                case 20: return 5;
                case 19: return 4;
                case 18: return 3;
                case 17: return 2;
                default: return 1;
            }
        }

    }


