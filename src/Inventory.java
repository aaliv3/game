import java.util.ArrayList;

/**
 * Methods for using items, checking inventory, adding items to inventory, etc.
 */

//Created an Inventory class to clear clutter from Player class
public class Inventory {

    //Defining a private array, which will be created when Inventory is called.
    private ArrayList<Items> items;

    //Creating that inventory
    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Items item) {
        items.add(item);
    }

    //Player can check on inventory
    public void showInventory() {
        //Will break out if nothing is in inventory
        if (items.isEmpty()) { // better way of checking if inventory is empty instead of 
            System.out.println("Inventory is empty");
            return;
        }
        //Else will print each inventory item 1 by 1
        System.out.println("Inventory:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ": " + items.get(i));
        }

    }

    /**
     * Checking if the player has a specific item
     * @param checkItem The item that is being checked for
     * @return True if the item is found
     */
    public boolean hasItem(String checkItem) {
        for (Items item : items) {
            if (item.getItemName().equals(checkItem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using an item in battle
     * @param index The item slot that is trying to be used
     * @param player The Player to heal if healing item is being used
     */
    //Check index number user entered and makes sure it is an index that exists.
    public void useItem(int index, Player player) {
        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid item slot/index");
            return;
        }

        //Uses that index number to set the corresponding item.
        Items item = items.get(index);

        //Checks if item has a Healing amount value and adds it to player health
        //And if health was to exceed 100, would be set to 100
        if (item.getHealingAmount() >0) {
            player.heal(item.getHealingAmount());

            System.out.println("You have used a " + item.getItemName() + " and healed\n");
            //If item is used, it will then be removed from Inventory
            items.remove(index);
        }
        else if (item.getItemDamage() > 0){
            player.setAttackDamage(item.getItemDamage());
            System.out.println("You have equipped a " + item.getItemDescription());
        }

        else{
            System.out.println("This item cannot heal you");
        }

    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
