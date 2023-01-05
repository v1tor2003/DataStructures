package dsjava;
public class Main {
  public static void main(String[] args) {
    DeckOfCards deckOfCards = new DeckOfCards();
    System.out.println(deckOfCards.toString());
    deckOfCards.shuffleCards();
    System.out.println(deckOfCards.toString());
  }
}
