import java.util.Random;

/**
 * Class for enemy information such as:
 * Enemy name, health, damage, item reward.
 */

public class Enemy {

    private String name;
    private int health;
    private int damage;
    private boolean isDefeated;
    private Items rewardItem;

    /**
     * Constructs a new Enemy with the details:
     * @param name       The display name for the enemy
     * @param health     How much health the enemy has
     * @param damage     How much damage the enemy deals to the player
     * @param rewardItem The items that is dropped by the enemy upon defeat
     */
    public Enemy(String name, int health, int damage, Items rewardItem) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        isDefeated = false;
        this.rewardItem = rewardItem;
    }

    // These methods will be used in class-Combat
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDefeated() {
        return isDefeated;
    }
    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isDefeated = true;
        }
    }

    /**
     * Generating the damage to be dealt to the player
     * @return The amount of health the player will lose
     */
    public int attack() {
        Random random = new Random();
        return random.nextInt(damage/2, damage); // Damage calc can change later idk
    }

    public int getDamage() {
        return damage;
    }

    public Items getRewardItem() {
        return rewardItem;
    }
}
