import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, ArrayList<String> residents, boolean hasDiningRoom) {
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
      throw new RuntimeException(name + " is already onboard " + this.name);
    }
    this.residents.add(name); // successfully moved in
  System.out.println(name + " successfully moved into " + this.name); 
  }
  
  /** 
   * removes resident out of House
   * @param name name of resident to move out
  */
  public String moveOut(String name) {
    if ((!this.residents.contains(name))) { // not resident of building
      throw new RuntimeException(name + " is not a resident of " + this.name);
  }
  this.residents.remove(name); // successfully moves out
  return name;
  }

  /** returns boolean of whether or not someone is a resident of a house
   * @param person name of resident to be checked
   */
  public boolean isResident(String person) {
    if ((this.residents.contains(person))) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    new House();
  }

}