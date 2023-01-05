package allQuestions.byUsingStack;

import java.util.Scanner;
import dsjava.stack.Stack;

public class ParkingLot {
  private static Scanner scanner = new Scanner(System.in);
  private static final int maxSpace = 3;
  private static final int maxFourDigitInteger = 9999;
  private static final char exitProgramChoice = '*';
  private static final char enterChoice = 'E';
  private static final char leaveChoice = 'S';
  private Stack<Car> cars = new Stack<>(maxSpace);

  public void open(){
    System.out.println(info());
    while(true){
      String input = getUserInput();
      char choice = input.charAt(0);
      // read stuff
      if(choice == exitProgramChoice){
        System.out.println("Closing Parking Lot.");
        System.out.println("Cars left: " + cars.size() + ".");
        return;
      }

      int plate = Integer.parseInt(input.substring(2, input.length()));
      if(choice == enterChoice){
        saveCar(plate);
      }else if(choice == leaveChoice){
        takeCarOut(plate);
      }
    }
  }

  private void saveCar(int plate){
    if(cars.isFull()){
      System.out.println("Parking Lot is Full.");
      return;
    }
    if(cars.contains(new Car(plate))){
      System.out.println("Car already exists.");
      return;
    }
    
    System.out.printf("Car added, Plate: %d.\n", plate);
    cars.push(new Car(plate));
  }

  private String getUserInput(){
    String input = "";
    boolean exit = false;

    do{
      if(scanner.hasNextLine()){
        input = scanner.nextLine();

        if(input.charAt(0) == exitProgramChoice) return input;
        if(isChoiceValid(input.charAt(0)) && isPlateValid(input.substring(2, input.length()))) exit = true;
      }else{
        System.out.println("Invalid Input, Try Again.");
        exit = false;
        scanner.next();
      }
    }while(!exit);

    return input;
  }

  private boolean isPlateValid(String str){
    try{
      int temp = Integer.parseInt(str);
      return temp > 0 && temp <= maxFourDigitInteger;
    }catch(NumberFormatException e){
      return false;
    }
  }

  private boolean isChoiceValid(char op){
    return (op == enterChoice || op == exitProgramChoice || op == leaveChoice);
  }

  private void takeCarOut(int plate){
    if(cars.isEmpty()){
      System.out.println("The Parking Lot is empty.");
      return;
    }

    Stack<Car> street = new Stack<>();
    while(!cars.isEmpty()){
      Car temp = cars.pop();
      temp.maneuver();
      if(temp.getPlate() == plate){
        loadCarsBackFrom(street);
        System.out.println("\nCar leaving: " + temp.toString());
        return;
      }else
        street.push(temp);
    }

    System.out.println("Car not found.");
  }

  private void loadCarsBackFrom(Stack<Car> street){
    while(!street.isEmpty() && !cars.isFull()){
      Car temp = street.pop();
      cars.push(temp);
    }
  }

  private static String info(){
    String str = "";
    str +=  "----Colcic Street Parking Lot----\n";
    str += "Select '*' to exit.\n";
    str +=  "Select 'E XXXX' to enter a Car.\n";
    str += "Select 'S XXXX' to take a Car out.\n";
    str += "Consider 'XXXX' as a Car Plate, up to a 4 digits.\n";

    return str;
  }

  public String toString(){
    if(cars.isEmpty()) return "The parking lot is empty.";
    return "Cars in the parking lot: " + cars.size();
  }
}
