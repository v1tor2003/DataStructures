package allQuestions.sorting;

import java.util.Comparator;

public class RegistrationComparator implements Comparator<Person>{
  @Override
  public int compare(Person p1, Person p2) {
    // TODO Auto-generated method stub
    
    if(p1.getRegistration() < p2.getRegistration()) return -1;
    else if(p1.getRegistration() > p2.getRegistration()) return 1;
    return 0;
  }
}
