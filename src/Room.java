import java.util.ArrayList;
import java.util.List;

public class Room {
    // Instance variables for items
    private String roomName; // room name
    private String roomDescription; // when the player first visits the room
    private String updatedRoomDescription; // for when the player has visited the room/completed some requirements for description to change (defeated enemy/picked up item)
    private Items items; // what item is in that room
    private Enemy enemy; // which enemy is in that room
    private NPC npc; // which npc is in that room

    // Constructor
    // missing npc hasMeet from constructor, might cause future issues, we will see..
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
    
    public String getRoomDescription() {
        return roomDescription;
    }
    
    public String getUpdatedRD() { // getUpdatedRoomDescription, RD short for RoomDescription
        return updatedRoomDescription;
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

    public NPC getNpc() {
        return npc;
    }
    public void setNpc(NPC npc) {
        this.npc = npc;
    }
}
