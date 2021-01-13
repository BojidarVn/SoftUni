package Card_Suit;

public class Main {
    public static void main(String[] args) {
      System.out.println("Card Ranks:");

     // System.out.println("Ordinal value: "+ CardSuit.CLUBS.ordinal() +"; " + "Name value: " + CardSuit.CLUBS);
     // System.out.println("Ordinal value: "  + CardSuit.DIAMONDS.ordinal() + "; " + "Name value: " + CardSuit.DIAMONDS);
     // System.out.println("Ordinal value: "  + CardSuit.HEARTS.ordinal() + "; " + "Name value: " + CardSuit.HEARTS);
     // System.out.println("Ordinal value: "  + CardSuit.SPADES.ordinal() + "; " + "Name value: " + CardSuit.SPADES);

        Enum[] values = CardRank.values();

        for (int i = 0; i < values.length; i++) {

            System.out.printf("Ordinal value: %d; Name value: %s%n", values[i].ordinal(),values[i]);

        }


    }
}
