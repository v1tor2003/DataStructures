import allQuestions.sorting.Person;
import allQuestions.sorting.menu.SortingMenu;

public class SortingProgram {
  public static void main(String[] args) {
    Person[] people = {
      new Person("B", 2, 8),
      new Person("A", 3, 7),
      new Person("C", 4, 10),
      new Person("F", 1, 5),
      new Person("V", 5, 8)
    };   

    SortingMenu menu = new SortingMenu(people);
    menu.run();
  } 
}
