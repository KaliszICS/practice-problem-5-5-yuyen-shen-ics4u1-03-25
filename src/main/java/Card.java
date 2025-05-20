class Card implements Comparable<Card>{
    private String name;
    private String suit;

    private static String[] names = {"Ace" , "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen" , "King"};
    private static String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};


    public Card(String name, String suit){
        this.name = name;
        this.suit = suit;
    }

    public String getName() {
        return this.name;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString() {
        return this.name + " of " + this.suit;
    }

    @Override
    public int compareTo(Card card) {
        int indexNameThis = indexOf(names, this.name);
        int indexNameOther = indexOf(names, card.getName());
        if (indexNameThis != indexNameOther) {
            return indexNameThis - indexNameOther;
        }
        int indexSuitThis = indexOf(suits, this.suit);
        int indexSuitOther = indexOf(suits, card.getSuit());
        return indexSuitThis - indexSuitOther;
    }

    public int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }


}