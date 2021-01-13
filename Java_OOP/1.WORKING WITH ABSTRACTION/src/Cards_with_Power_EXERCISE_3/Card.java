package Cards_with_Power_EXERCISE_3;

public class Card {
    private String type;
    private String suit;

    public Card(String type, String suit) {
        this.type = type;
        this.suit = suit;

    }

    @Override
    public String toString() {
        return String.format("Card name: %S of %s; Card power: %d"
                , type, suit, getPower());
    }

    private int getPower() {

        return CardRank.valueOf(type).getValue()+ CardSuit.valueOf(suit).getValue();
    }
}
