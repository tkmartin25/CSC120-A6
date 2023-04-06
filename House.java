import java.util.ArrayList;

/**
 * House class is an extension of building class
 */
public class House extends Building {
  /** names of the residents that live in the house */
  private ArrayList<String> residents; 
  /** whether or not the house has a dining hall */
  private boolean hasDiningRoom;
  /** whether or not the house has an elevator */
  private boolean hasElevator;

  /**
   * creates house, unknown name, address, and default 1 floor
   */
  public House(){
    System.out.println("You have built a house: 🏠");
  }

  /**
   * creates house with only name as input
   * @param name
   */
  public House(String name){
    this.name = name;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * creates a house with building attributes but also names of residents and dining room info
   * @param name
   * @param address
   * @param nFloors
   */
  public House(String name, String address, int nFloors){
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
  }

  /**
   * creates a house with building attributes but also names of residents and dining room info
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom; 
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /** dining room accessor */
  public boolean hasDiningRoom() {
    return hasDiningRoom();
  }

  /** accessor of number of residents */
  public int nResidents() {
    return residents.size();
  }

  /** 
   * resident moves into house
   * @param name name of resident 
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) { // already in building
      throw new RuntimeException(name + " is already a resident of " + this.name + ".");
    }
    this.residents.add(name); // successfully moved in
    System.out.println(name + " successfully moved into " + this.name + "."); 
  }
  
  /** 
   * removes resident out of House
   * @param name name of resident to move out
   */
  public String moveOut(String name) {
    if ((!this.residents.contains(name))) { // not resident of building
      throw new RuntimeException(name + " is not a resident of " + this.name + ".");
    }
    else if (name == "Tejas Kumaran") {
      System.out.println("Tejas Kumaran cannot leave " + this.name + ".");
    }
    else {
      System.out.println(name + " has moved out of " + this.name + ".");
      this.residents.remove(name); 
    } // successfully moves out
    return name;
  }

  /** returns boolean of whether or not someone is a resident of a house
   * @param person name of resident to be checked
   */
  public boolean isResident(String person) {
    if ((this.residents.contains(person))) {
      System.out.println(person + " is a resident of " + this.name + ".");
      return true;
    } else {
      System.out.println(person + " is not a resident of " + this.name + ".");
      return false;
    }
  }

  /**
   * shows actions available at house
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(n)\n + moveOut(n)");
  }
  
  /**
   * goes to floor levels depending on whether or not the house is known to have an elevator
   * @param floorNum
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    else if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    else if (floorNum == this.activeFloor) {
        throw new RuntimeException("You are already on floor # " + floorNum);
    }
    else if (this.hasElevator == true) {
      System.out.println("You took the elevator. You are now on floor #" + floorNum + " of " + this.name + ".");
      this.activeFloor = floorNum;
    }
    else if (this.hasElevator == false) {
      if (floorNum == this.activeFloor + 1) {
        this.activeFloor = floorNum;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name + ".");
      }
      else if (floorNum == this.activeFloor - 1) {
        this.activeFloor = floorNum;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name + ".");
      }
      else {
        throw new RuntimeException("This building does not have an elevator. You can only go up or down one floor at a time.");
      }
    }
  }

  /** for testing */
  public static void main(String[] args) {
    House myHouse = new House("Chapin House", "3 Chapin Way", 4, false, false);
    House Cutter = new House("Cutter House", "10 Elm Street", 4);
    myHouse.moveIn("Teddy Martin");
    myHouse.moveIn("Tejas Kumaran"); 
    myHouse.moveIn("Anna-Lee Thompson");
    myHouse.isResident("Tejas Kumaran");
    myHouse.moveOut("Tejas Kumaran");
    myHouse.moveOut("Teddy Martin");
    myHouse.showOptions();
    myHouse.enter();
    myHouse.goToFloor(2);
    Cutter.enter();
    Cutter.goToFloor(2);
    House myHouse2 = new House();
    myHouse2.enter();
    House westport = new House("Abby's House");
    westport.enter();
    westport.goUp();
  }

}

