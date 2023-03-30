import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {
  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * adds book to collection
   * @param title
   */
  public void addTitle(String title) {
    //if (this.collection.contains(title)) { // already in collection
    //  throw new RuntimeException(title + " is already title in the collection of " + this.name + ".");
    //}
    this.collection.put(title, true); // successfully added to collection
    System.out.println(title + " was successfully added to the collection of " + this.name + "."); 
  }

  /**
   * removes title from library's collection and returns title of removed book
   * @param title
   * @return title
   */
  public String removeTitle(String title) {
    //if (!this.collection.contains(title)) { // not in collection
    // throw new RuntimeException(title + " is not a title in the collection of " + this.name + ".");
    //}
    this.collection.remove(title); // successfully removed from collection
    System.out.println(title + " was successfully removed from the collection of " + this.name + "."); 
    return title;
  }

  /**
   * checks out book to library using book title
   * @param title title by author of book to be checked out
  */
  public void checkOut(String title) {
    if (!this.isAvailable(title)) {
      throw new RuntimeException(title + " is already checked out at " + this.name + ".");
    }
    System.out.println(title + " was successfully checked out at " + this.name + ".");
    this.collection.replace(title, true, false);
  }

  /**
   * returns book to library using book title
   * @param title title by author of book to be returned
  */
  public void returnBook(String title) {
    if (this.isAvailable(title)) {
      throw new RuntimeException(title + " is not checked out at " + this.name + ".");
    }
    System.out.println(title + " was successfully returned to " + this.name + ".");
    this.collection.replace(title, false, true);
  }

  /**
   * tells user if a book is in the library's collectino
   * @param title
   * @return boolean, whether or not book is in collection
   */
  public boolean containsTitle(String title) { // returns true if the title appears as a key in the Libary's collection, false otherwise
    if (this.collection.containsKey(title)) {
      System.out.println(title + " is part of the collection at " + this.name + ".");
      return true;
    }
    else {
      System.out.println(title + " could not be found in the collection at " + this.name + ".");
      return false;
    }
  }
  
  /**
   * tells user whether or not a book is available to be checked out
   * @param title
   * @return true if title is currently available, false if not available
   */
  public boolean isAvailable(String title) { // returns true if the title is currently available, false otherwise
    if (this.collection.get(title) == true) {
      System.out.println(title + " is available at " + this.name + ".");
      return true;
    }
    else {
      System.out.println(title + " is not available at " + this.name + ".");
      return false;
    }
  }

  /**
   * prints all titles and their checked out status in the collection
   */
  public void printCollection() { // prints out the entire collection in an easy-to-read way (including checkout status)
    System.out.println(collection.entrySet());
  }

  /** for testing */
  public static void main(String[] args) {
    Library Neilson = new Library("Neilson Library", "Smith College", 4);
    Neilson.addTitle("Salt to the Sea by Ruta Sepetys");
    Neilson.addTitle("Madeline by Ludwig Bemelmans");
    Neilson.isAvailable("Salt to the Sea by Ruta Sepetys");
    Neilson.containsTitle("Salt to the Sea by Ruta Sepetys");
    Neilson.printCollection();
    Neilson.checkOut("Salt to the Sea by Ruta Sepetys");
    Neilson.isAvailable("Salt to the Sea by Ruta Sepetys");
    Neilson.returnBook("Salt to the Sea by Ruta Sepetys");
    Neilson.isAvailable("Salt to the Sea by Ruta Sepetys");
  }
  
}