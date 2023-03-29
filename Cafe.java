/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        System.out.println("You sold a coffee with the size of " + size + ", " + nSugarPackets + " sugar packet(s), " + "and " + nCreams + " cream(s).");
    }

    public void printInventory() {
        System.out.println(this.name + " currently has " + this.nCoffeeOunces + " cups, " + this.nSugarPackets + " sugar packet(s), " + "and " + this.nCreams + " cream(s).");
    }
    
    public static void main(String[] args) {
        Cafe Ediya = new Cafe("Ediya Coffee", "5 Mapogu Way", 1, 30, 20, 10, 10);
        Ediya.sellCoffee(3, 1, 1);
        Ediya.printInventory();
    }
    
}
