package allQuestions.byUsingStack;
import dsjava.stack.Stack;

public class ExpressionValidator {
  private static final char[] openingElements = {'(', '{', '['};
  private static final char[] closingElements = {')', '}', ']'};

  public static boolean isClosureValid(String expresion){
    final char[] expresionAsCharArray = expresion.toCharArray();
    Stack<Character> stack = new Stack<>();
    // fills the stack checking if the current element is a openning a tag
    // when the stack is empty and the current element is a closing tag it returns false
    // else we peek() the last in and compare its closure with our current
    // if the current is a closing tag of the last in, we pop() the last in
    // else we push the current in
    // at the end of the for each, the stack must be empty for a valid expression
    for (char currentElement : expresionAsCharArray){
      if(!stack.isEmpty()){
        char lastInsulatorIn = stack.peek();
        if(isClosingElementOfLastIn(lastInsulatorIn, currentElement))
          stack.pop();
        else{
          if(isOpeningElement(currentElement))
            stack.push(currentElement);
        } 
      }else{
        if(isOpeningElement(currentElement))
          stack.push(currentElement);
        else if(isClosingElement(currentElement))
          return false;
      }
    }
  
    return stack.isEmpty();
  }

  // looks for a matching element in a given array, given the element we want find 
  private static int findClosureElement(char currentElement, char[] array){
    for(int i = 0; i < array.length; i++)
      if(currentElement == array[i])
        return i;

    return -1;
  }

  private static boolean isOpeningElement(char currentElement) {
    return findClosureElement(currentElement, openingElements) != -1;
  }

  private static boolean isClosingElement(char currentElement) {
    return findClosureElement(currentElement, closingElements) != -1;
  }

  //finds the pair of a opening tag in the closingElements array
  private static boolean isClosingElementOfLastIn(char opening, char closing) {
    if(!isOpeningElement(opening))
      return false;
    return closing == closingElements[findClosureElement(opening, openingElements)];
  }
}
