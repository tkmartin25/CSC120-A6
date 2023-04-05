import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Chapin House", "3 Chapin Way Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St Northampton, MA 01063", 1, 50, 70, 40, 200));
        myMap.addBuilding(new Building("Hubbard House", "3 Green St Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Park House", "134 Elm St Northampton, MA 01063", 2));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 5, true));
        myMap.addBuilding(new Building("Mendenhall", "122 Green St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Ziskind House", "1 Henshaw Ave Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Tyler House", "151-199 Green St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Lawrence House", "78 Green St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Baldwin House", "15 Bedford Terrace Northampton, MA 01063", 2));
        System.out.println(myMap);
    }
    
}