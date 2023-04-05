/**
 *  cafe class is an extension of the building class
 */
public class Cafe extends Building {
    /** the number of ounces of coffee remaining in inventory */
    private double nCoffeeOunces; 
    /** the number of sugar packets remaining in inventory */
    private int nSugarPackets; 
    /** the number of "splashes" of cream remaining in inventory */
    private int nCreams; 
    /** the number of cups remaining in inventory */
    private int nCups;

    /**
     * Create a cafe that can sell coffee and update inventory
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, double nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * sells coffee and reduces nCups by 1, and other variables by user specifications in the parameters
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > this.nCoffeeOunces) {
            this.restock(50);
        }
        if (nSugarPackets > this.nSugarPackets) {
            this.restock(0, 50, 0, 0);
        }
        if (nCreams > this.nCreams) {
            this.restock(0, 0, 25, 0);
        }
        if (this.nCups < 1) {
            this.restock(0, 0, 0, 100);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
        System.out.println("You sold a coffee with the size of " + size + ", " + nSugarPackets + " sugar packet(s), " + "and " + nCreams + " cream(s).");
    }

    /**
     * sells Coffee but simpler orders without sugar and cream, and also can sell multiple cups at once
     * @param size
     * @param nCups
     */
    public void sellCoffee(int size, int nCups) {
        if (size > this.nCoffeeOunces) {
            this.restock(50);
        }
        if (this.nCups < nCups) {
            this.restock(0, 0, 0, 100);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nCups = this.nCups - nCups;
        System.out.println("You sold " + nCups + " cups of coffee with the size of " + size + ".");
    }

    /**
     * prints out inventory including number of cups, coffee ounces, sugar packets, and creams.
     */
    public void printInventory() {
        System.out.println(this.name + " currently has " + this.nCups + " cup(s), " + this.nCoffeeOunces + " coffee ounce(s), " + this.nSugarPackets + " sugar packet(s), " + "and " + this.nCreams + " cream(s) in its inventory.");
    }

    /**
     * restocks inventory by specified amounts of parameters
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(double nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
        System.out.println("The inventory has been updated.");
        this.printInventory();
    }

    /**
     * overloading restock()
     * restocks inventory for coffeeOunces and takes int as input
     * @param nCoffeeOunces
     */
    private void restock(int nCoffeeOunces) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        System.out.println("The inventory has been updated.");
        this.printInventory();
    }
    
    /**
     * shows available actions to take at cafe
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(s, sp, c)\n + restock(co, s, c, cu)\n + printInventory()");
      }

    /** for testing */
    public static void main(String[] args) {
        Cafe Ediya = new Cafe("Ediya Coffee", "5 Mapogu Way", 1, 30, 20, 10, 0);
        Ediya.sellCoffee(3, 1, 1);
        Ediya.sellCoffee(3, 2);
        Ediya.restock(30.5, 2, 3, 4);
        Ediya.restock(30);
        Ediya.printInventory();
        Ediya.showOptions();
    }
    
}
