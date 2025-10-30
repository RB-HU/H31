public class Card {

        private String suit;
        private String rank;
        private int value;

        public Card(String suit, String rank) {
            this.suit=suit;;
            this.rank=rank;
            this.value=calculateValue(rank);
        }

        private int calculateValue(String rank) {
            if (rank.equals("A"))
            {
                return 1;
            }
            else if (rank.equals("J")||rank.equals("Q")||rank.equals("K")) {
                return 10;
            }
            else {
                return Integer.parseInt(rank);
            }
        }

        public String getSuit()
        { return suit;
        }
        public String getRank()
        { return rank;
        }
        public int getValue()
        { return value;
        }

        public String toString() {
            return rank + suit;
        }

}
