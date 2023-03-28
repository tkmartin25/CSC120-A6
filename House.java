import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
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
  
  public static void main(String[] args) {
    House myHouse = new House("Chapin House", "3 Chapin Way", 4, false);
    myHouse.moveIn("Teddy Martin");
    myHouse.moveIn("Tejas Kumaran"); 
    myHouse.moveIn("Anna-Lee Thompson");
    myHouse.isResident("Tejas Kumaran");
    myHouse.moveOut("Tejas Kumaran");
    myHouse.moveOut("Teddy Martin");

  }

}

