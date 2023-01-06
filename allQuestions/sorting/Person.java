package allQuestions.sorting;

public class Person{
  private int registration;
  private String name;
  private float grade;

  public Person(String name, int registration, float grade){
    this.grade = grade;
    this.name = name;
    this.registration = registration;
  }

  public int getRegistration(){
    return this.registration;
  }

  public float getGrade(){
    return this.grade;
  }

  public String getName(){
    return this.name;
  }

  public String toString(){
    return String.format("Name: %s, Registration: %d, Grade: %.2f.\n",  this.name, this.registration, this.grade);
  }
}
