package allQuestions.byUsingStack;

public class Car implements Comparable<Car>{
  private int timesManeuvered = 0;
  private int plate;

  public Car(int plate){
    this.plate = plate;
  }

  public void maneuver(){
    this.timesManeuvered++;
  }

  public int getPlate(){
    return this.plate;
  }

  public String toString(){
    return String.format("Plate: %d, Maneuvered: %dx\n", this.plate, this.timesManeuvered); 
  }

  @Override
  public int compareTo(Car obj) {
    // TODO Auto-generated method stub
    if(this.plate < obj.getPlate())
      return -1;
    else if(this.plate > obj.getPlate())
      return 1;

    return 0;
  }

  @Override 
  public boolean equals(Object obj){
    return compareTo((Car) obj) == 0;
  }
}
