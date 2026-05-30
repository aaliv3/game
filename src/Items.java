public class Items {

    //Creating instance variables for Items
    private String itemName;
    private String itemDescription;
    private int itemDamage;
    private int healingAmount;


    //Using a Constructor so these parameters must be passed though and set to the instance variables above.
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
        return itemName;
    }

}
