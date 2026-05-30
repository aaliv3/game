
/**
 * Class for player information such as:
 * Player position, inventory, and health.
 */

public class Player {
    public int health;
    private String playerName;
    public Inventory inventory;
    private int attack;
    private int row;
    private int column;

    public Player(String playerName) {
        health = 100; // This can change, just picking a random number for now
        row = 3;
        column = 0;
        this.playerName = playerName; //Added this to accept player input as name through main
        inventory = new Inventory();
        attack = 1;
    }

    //Can call to access Inventory from main and add items
    public Inventory getInventory() {
        return inventory;
    }
    public int getHealth() {
        return health;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //Gets attack damage
    public int attackDamage(){
        return attack;
    }

    //Sets attack damage to value of item when called.
    public void setAttackDamage(int itemDamage){
         attack = itemDamage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }

   //Moved into Player class, instead of inventory.
    //I was getting issues trying to call player.health from inventory and modifying it there
    public void heal(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }
    /*
     * For changing player position when moving
     */
    public void moveNorth() {
        row -= 1;
    }
    public void moveSouth() {
        row += 1;
    }
    public void moveEast() {
        column += 1;
    }
    public void moveWest() {
        column -= 1;
    }

}

