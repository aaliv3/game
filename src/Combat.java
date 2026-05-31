import java.util.Random;
import java.util.Scanner;

public class Combat {

    // Combat cycle
    public static void combat(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int enemyAttack;
        int playerAttack;


        System.out.println("You have entered combat with " + enemy.getName() + "!");
        while (player.getHealth() > 0 && !enemy.isDefeated()) {
            System.out.println("You have " + player.getHealth() + " health remaining!\n");
            System.out.println("What do you want to do?");
            System.out.println("Do you want to (F)ight, (U)se an item or (R)un");
            String combatDecision = scanner.nextLine().toLowerCase();
            boolean playerRun = false;

            if (combatDecision.equals("f")) {

                playerAttack = player.attackDamage();
                enemy.takeDamage(playerAttack);

                System.out.printf("You have attacked %s and dealt %d damage.\n%s has %d health remaining\n\n",
                        enemy.getName(), playerAttack, enemy.getName(), enemy.getHealth());

                //this checks after player combat if enemy health is 0 or less, and if so sets the enemy to defeated
                if(enemy.getHealth() <= 0) {
                    enemy.setDefeated(true);
                    System.out.println("You have slain the " + enemy.getName());
                    break;
                }

                //checks if enemy is defeated before enemy can attack
                if(!enemy.isDefeated()) {
                    enemyAttack = enemy.attack();
                    player.takeDamage(enemyAttack);

                    System.out.printf("%s has attacked and dealt %d to you.\n", enemy.getName(), enemyAttack);
                }
            }

            else if (combatDecision.equals("u")) {

                if(player.getInventory().isEmpty()) {
                    System.out.println("You have no inventory!");
                }

                else {
                    System.out.println("What item number would you like to use/equip?");
                    player.inventory.showInventory();
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine(); //Was creating extra inputs, this fixs
                    player.inventory.useItem(itemNumber, player);
                }
            }

            else if (combatDecision.equals("r")) {
                playerRun = random.nextBoolean();
                if (playerRun) {
                    System.out.println("You have fled combat");
                    break;
                } else {
                    System.out.println("You failed to run away and the " + enemy.getName() + " got a critical hit in!");
                    //Added the +1, s that player is given at least on more chance to fight
                    player.setHealth((player.getHealth() / 2) + 1);
                }
            }

            else {
                System.out.println("Invalid combat choice. Please try again.");
            }
        }
        if (player.getHealth() <= 0) {
            System.out.println("You have died in combat to " + enemy.getName() + "!");
        }

    }
}
