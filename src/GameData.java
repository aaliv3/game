import java.io.IOException;
import java.util.Scanner;

// initalising game data
// instead of initalising all game data in the main method
public class GameData {
    private Room[][] map;
    private Player player;
    private Boolean gameRunning;

    public void start() {
        clearScreen();
        map = new Room[4][4];
        gameRunning = true;
        createMap();

        System.out.println("Welcome to the game"); // Add more game intro stuff here

        Scanner userInput = new Scanner(System.in);
        System.out.printf("Please enter your player name: ");
        String playerName = userInput.nextLine();
        player = new Player(playerName);
        printInstructions();

        while (gameRunning && player.getHealth() > 0) { // main running loop
            Room currentRoom = getCurrentRoom();
            System.out.println(currentRoom.getRoomDescription());

            System.out.println("\nWhat would you like to do? (use 'help' for help)");
            String input = userInput.nextLine().toLowerCase();

            clearScreen();
            handleInput(input);
            
        }
        userInput.close();
    }

    private void handleInput(String input) {
        switch (input) {
            case "n":
            case "s":
            case "e":
            case "w":
                movePlayer(input);
                break;

            case "inv":
                player.getInventory().showInventory();
                break;

            case "pickup":
                pickupItem();
                break;

            case "talk":
                talkToNpc();
                break;

            case "fight":
                fightEnemy();
                break;

            case "help":
                printInstructions();
                break;

            case "quit":
                gameRunning = false;
                break;

            case "\u0003": // Ctrl+C character
                gameRunning = false;
                break;  

            default:
                System.out.println("Invalid input");
        }
    }

    private void createMap() {

        map[3][0] = new Room("Castle Entrance",
                "The grand gates leading into the castle.",
                "The gates have now shut, there is no turning back.");

        map[3][1] = new Room("Lobby",
                "An open lobby with a branching path. There is an old man beckoning you over.",
                "The old man is still there.");

        map[3][2] = new Room("FirstBossRoom",
                "A large key sits on the desk. There is a goblin guarding it.",
                "An empty room with the corpse of a goblin.");

        map[2][1] = new Room("Locked Hallway.",
                "A locked door blocks your path.",
                "The door is now open. You are free to pass through.");
        map[2][1].setNeedsKey("Hallway Key");

        map[1][1] = new Room("Hallway",
                "An empty corridor with a path to the left and right.",
                "The hallway is still empty.");

        map[1][0] = new Room("Brewery",
                "Broken vials and brewing equipment lie all over. There is one remaining health potion.",
                "Nothing remains but a mess the goblins left behind.");

        map[1][2] = new Room("SecondEnemyRoom",
                "A large troll blocks your way. Your only option is to fight.",
                "The trolls corpse lies in the corner.");

        map[0][2] = new Room("King's Throne",
                "The Dead King stands before you. This is it.",
                "The corpse of your enemy is sat lifeless on the throne. You did it.");

        map[0][3] = new Room("Treasure Room",
                "",
                "");

        //Have added this to the npc instead, so that the npc can give it to the player after speaking.
        //map[3][1].setItems(new Items("Broken Sword", "Flimsy Broken Sword", 5, 0));

        map[3][1].setNpc(new NPC("Wise Old Man", "Hello traveller, looks like you could use some help on your journey.Take this...", "Go use that sword for good!", false,new Items("Broken Sword", "Flimsy Broken Sword", 5, 0)));
        map[1][0].setNpc(new NPC("Potion Master", "Hello there, you seem to have been injured on your adventure. This might be helpful", "Make sure to use that potion in bottle",false,new Items("Healing Potion", "Healing Potion that will restore 60 health", 0, 60)));

        map[3][2].setEnemy(new Enemy("FirstEnemy", 30, 20, new Items("Hallway Key", "Key to unlock dungeon exit", 0, 0)));
        map[1][2].setEnemy(new Enemy("SecondsEnemy", 50, 35, new Items("Golden Sword", "Strong Golden Sword", 20, 0)));
        map[0][2].setEnemy(new Enemy("FinalBoss", 200, 40, new Items("Golden Key", "Key to unlock dungeon exit", 0, 0)));

    }

    private Room getCurrentRoom() {
        return map[player.getRow()][player.getColumn()];
    }

    private boolean isRoomLocked(Room currentRoom, Player player, String requiredKey) {
        return (!player.getInventory().hasItem(requiredKey) && !(currentRoom.getKeyNeeded() == null));
    } // if the player doesnt have required key and the room needs a key return true

    private void movePlayer(String direction) {

        int row = player.getRow();
        int column = player.getColumn();

        switch (direction) {
                case "n":
                    if (row > 0 && map[row - 1][column] != null) {
                        player.moveNorth();
                        if (isRoomLocked(getCurrentRoom(), player, getCurrentRoom().getKeyNeeded())) {
                            System.out.println("This room is locked, Perhaps you could find a key somewhere else.");
                            System.out.println("Returning to revious room.");
                            player.moveSouth();
                            break;
                        }
                        
                    } else {
                        System.out.println("You cannot go north.");
                    }
                    break;

                case "s":
                    if (row < map.length -1 && map[row + 1][column] != null) {
                        player.moveSouth();
                        if (isRoomLocked(getCurrentRoom(), player, getCurrentRoom().getKeyNeeded())) {
                            System.out.println("This room is locked, Perhaps you could find a key somewhere else.");
                            System.out.println("Returning to revious room.");
                            player.moveNorth();
                            break;
                        }
                        
                    } else {
                        System.out.println("You cannot go south.");
                    }
                    break;

                case "e":
                    if (column < map[0].length - 1 && map[row][column + 1] != null) {
                        player.moveEast();
                        if (isRoomLocked(getCurrentRoom(), player, getCurrentRoom().getKeyNeeded())) {
                            System.out.println("This room is locked, Perhaps you could find a key somewhere else.");
                            System.out.println("Returning to revious room.");
                            player.moveWest();
                            break;
                        }
                        
                    } else {
                        System.out.println("You cannot go east.");
                    }
                    break;

                case "w":
                    if (column > 0 && map[row][column - 1] != null) {
                        player.moveWest();
                        if (isRoomLocked(getCurrentRoom(), player, getCurrentRoom().getKeyNeeded())) {
                            System.out.println("This room is locked, Perhaps you could find a key somewhere else.");
                            System.out.println("Returning to revious room.");
                            player.moveEast();
                            break;
                        }
                        
                    } else {
                        System.out.println("You cannot go west.");
                    }
                    break;
        }
    }

    private void pickupItem() {
        Room room = getCurrentRoom();

        if (room.getItems() != null) {
            player.getInventory().addItem(room.getItems());
            System.out.println("You picked up "  + room.getItems().getItemName());
            room.setItems(null);
        }
        else {
            System.out.println("There is nothing to pick up.");
        }
    }

    private void talkToNpc() {
        Room room = getCurrentRoom();

        if (room.getNpc() == null) {
            System.out.println("There is nobody here.");
            return;
        }

        //Prints first dialogue until spoken to.
        NPC npc = room.getNpc();
        System.out.println(npc.getDialogue());

        //Check is the npc hasn't givenreward and if they have an item. If so this runs
        if(!npc.isRewardGiven() && npc.getReward() != null) {
            room.setItems(npc.getReward());
            npc.setRewardGiven(true);

            System.out.println("A " + npc.getReward().getItemName() + " has been placed onto the floor in front of you");
        }

    }

    private void fightEnemy() {
        Room room = getCurrentRoom();

        if (room.getEnemy() != null && !room.getEnemy().isDefeated()) {
            Combat.combat(player, room.getEnemy());

            if(room.getEnemy().isDefeated()) {
                room.setItems(room.getEnemy().getRewardItem());

                System.out.println(room.getEnemy().getRewardItem().getItemName() + " has dropped onto the floor in front of you");
            }

        } else {
            System.out.println("There is no enemy to fight.");
        }
    }

    private void clearScreen(){
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) { // gets operating system name
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } // creates a process, connects to your terminal, starts the process, waits for the command to complete
        } catch (IOException | InterruptedException e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Please run in windows terminal or bash terminal");
        }
    }

    private void printInstructions() {
        System.out.println("\nCommands:");
        System.out.println("n/s/e/w - move");
        System.out.println("inv - show inventory");
        System.out.println("pickup - collect item");
        System.out.println("talk - talk to NPC");
        System.out.println("fight - start combat");
        System.out.println("help - print this menu");
        System.out.println("quit - exit game");
    }
}