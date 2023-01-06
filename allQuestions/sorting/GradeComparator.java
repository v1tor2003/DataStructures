package allQuestions.sorting;

import java.util.Comparator;

public class GradeComparator implements Comparator<Person>{
  @Override
  public int compare(Person p1, Person p2) {
    // TODO Auto-generated method stub
    if(p1.getGrade() > p2.getGrade()) return 1;
    else if(p1.getGrade() < p2.getGrade()) return -1;

    return 0;
  }
}
