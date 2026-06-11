import java.util.ArrayList;
import java.util.List;

/**
 * Class for player information such as:
 * Room name, descriptions, locked status, NPCs/Enemy, items.
 */

public class Room {
    // Instance variables for items
    private String roomName; // room name
    private String roomDescription; // when the player first visits the room
    private String updatedRoomDescription; // for when the player has visited the room/completed some requirements for description to change (defeated enemy/picked up item)
    private String requiredKey;
    private Items items; // what item is in that room
    private Enemy enemy; // which enemy is in that room
    private NPC npc; // which npc is in that room
    private boolean completed = false;

    /**
     * Constructs a new Room object with the details:
     * @param roomName               The name of the room
     * @param roomDescription        The description which is displayed upon entering the room
     * @param updatedRoomDescription An updated room description for when a certain requirement has been met
     */
    public Room(String roomName, 
                String roomDescription, 
                String updatedRoomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.updatedRoomDescription = updatedRoomDescription;
    }
    
    public String getRoomName() {
        return roomName;
    }

    /**
     * Check if the room has been completed and return either the original or updated room description.
     * @return The room description to be displayed
     */
    public String getRoomDescription() {
        if(completed) {
            return updatedRoomDescription;
        }
        return roomDescription;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Not all rooms have items/enemy/npc, so created setter methods for them instead of being in constructor
    public Items getItems() {
        return items;
    }
    public void setItems(Items items) {
        this.items = items;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setNeedsKey(String requiredKey) {
        this.requiredKey = requiredKey;
    }
    
    public String getKeyNeeded() {
        return requiredKey;
    }
    

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
}
