import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private boolean isDefeated;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        isDefeated = false;
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

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isDefeated = true;
        }
    }

    public int attack() {
        Random random = new Random();
        return random.nextInt(damage/2, damage); // Damage calc can change later idk
    }

    public int getDamage() {
        return damage;
    }

}
