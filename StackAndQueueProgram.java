import allQuestions.byUsingQueue.PrimeNumber;
import allQuestions.byUsingStack.DeckOfCards;
import allQuestions.byUsingStack.ExpressionValidator;
import allQuestions.byUsingStack.ParkingLot;

public class StackAndQueueProgram {
  public static void main(String[] args) {
    // [Stack] Question 4 - Sort a deck of cards by using stacks
    DeckOfCards deckOfCards = new DeckOfCards();
    System.out.println(deckOfCards.toString());
    deckOfCards.shuffleCards(); // method that sorts the cards
    System.out.println(deckOfCards.toString());

    // [Stack] Question 5 - Validate parentheses, square brackets and curly brackets on a expression
    String[] expressions = {
      new String("{[(5 × 7)/5] × 4 - [(5 × 7) × 2]} /(3 × 6)"),
      new String("{2 + [(16 + 2 ∧ 3) - 4)} × 3")
    };
    for (String expression : expressions)
      System.out.println(ExpressionValidator.isClosureValid(expression));

    // [Stack] Question 6 - Colcic Street Parking Lot
    ParkingLot colcicParkingLot = new ParkingLot();
    colcicParkingLot.open();

    // [Queue] Question 4 - Prime factors of a given n in desc order
    PrimeNumber.primeFactors(3960);
  }
}
