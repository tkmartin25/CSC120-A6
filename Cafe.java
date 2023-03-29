/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Cafe constructor
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
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
            this.restock(50, 0, 0, 0);
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
     * prints out inventory including number of cups, coffee ounces, sugar packets, and creams.
     */
    public void printInventory() {
        System.out.println(this.name + " currently has " + this.nCups + " cup(s), " + this.nCoffeeOunces + " coffee ounce(s), " + this.nSugarPackets + " sugar packet(s), " + "and " + this.nCreams + " cream(s) in its inventory.");
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
        System.out.println("The inventory has been updated.");
        this.printInventory();
    }
    
    public static void main(String[] args) {
        Cafe Ediya = new Cafe("Ediya Coffee", "5 Mapogu Way", 1, 30, 20, 10, 0);
        Ediya.sellCoffee(3, 1, 1);
        Ediya.printInventory();
    }
    
}
