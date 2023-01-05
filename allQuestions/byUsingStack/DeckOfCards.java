package allQuestions.byUsingStack;

import java.util.Random;
import dsjava.stack.Stack;

public class DeckOfCards {
  // Using Integer as a "Card"
  private static Random random = new Random();
  private static final int deckSize = 52;
  Stack<Integer> cards = new Stack<>(deckSize);
  
  public DeckOfCards(){
    fillDeck(cards);
  }

  private void fillDeck(Stack<Integer> cards){
    for(int i = 0; i < deckSize; i++)
      cards.push(i);
  }

  public void shuffleCards(
    /*if using the array solution we would pass the number 
      of partitions to divide the cards, as a Integer number <= deckSize ofc
    */
  ){
    
      // I think there is a better solution
    // By using an array to store the auxs stacks (but we can not create a generic type array in Java)
    // Would look like this
    /*
    partitionSize = calcule numbers based on the quantity of partitions for their sum be equal 52
    Stack<Integer> auxs [] = new Stack[numberOfPartitions]
    
    for each Stack<Integer> stack in auxs)
      stack = new Stack(partitionSize)
    
    while(!cards.isEmpty())
      int gen = random.nextInt(numberOfPartitions)
      if(!auxs[gen].isFull()) auxs[gen].push(cards.pop())
    end

    while(!cards.isFull)
      int currentAuxStack = 0
      takeBackFrom(auxs[currentAuxStack])
      currentAuxStack++
    end
    */

    // Solving without an array
    Stack<Integer> s0 = new Stack<>(17);
    Stack<Integer> s1 = new Stack<>(17);
    Stack<Integer> s2 = new Stack<>(18);

    // distribute the cards from the main cards to smaller partitions
    while(!cards.isEmpty()){
      int gen = random.nextInt(3);
      if(gen == 0 && !s0.isFull()) s0.push(cards.pop());
      if(gen == 1 && !s1.isFull()) s1.push(cards.pop());
      if(gen == 2 && !s2.isFull()) s2.push(cards.pop());
    }

    // push eveything back from each aux stack
    takeBackFrom(s0);
    takeBackFrom(s1);
    takeBackFrom(s2);
  }

  private void takeBackFrom(Stack<Integer> aux){
    while(!aux.isEmpty()) cards.push(aux.pop());
  } 

  @Override
  public String toString(){
    return cards.toString();
  }
}
