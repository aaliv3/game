/**
 * Class for item information such as:
 * Item name, description, damage, healing.
 */
public class Items {
    //Creating instance variables for Items
    private String itemName;
    private String itemDescription;
    private int itemDamage;
    private int healingAmount;


    /**
     * Constructs a new Items with the details:
     * @param itemName        The display name for the item
     * @param itemDescription The description of the item
     * @param itemDamage      How much damage dealt when used as a weapon
     * @param healingAmount   How much health recovered when used
     */
    public Items(String itemName, String itemDescription, int itemDamage, int healingAmount) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemDamage = itemDamage;
        this.healingAmount = healingAmount;

    }

    //Using getVariableName to return specific values of an Item when called.
    public String getItemName() {
        return itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public int getItemDamage() {
        return itemDamage;
    }
    public int getHealingAmount() {
        return healingAmount;
    }

    //Needed to add an Override statement so that the actual item names would be called instead of the random characters
    @Override
    public String toString() {
        return itemName +" - " + itemDescription;
    }

}
