/**
 * Class for NPC information such as:
 * NPC name, dialogue, item rewards.
 */
public class NPC {
    private String name;
    private String greeting;
    private String repeatGreeting;
    private boolean hasSpoken;
    private Items reward;
    private boolean rewardGiven;

    /**
     * Constructs a new NPC with the details:
     * @param name           The name of the NPC
     * @param greeting       NPC dialogue for when the player greets them
     * @param repeatGreeting NPC dialogue for repeat interactions
     * @param hasSpoken      Declares if the NPC should use greeting or repeatGreeting when talked with
     * @param reward         The item that the NPC gives to the player
     */

    public NPC(String name, String greeting, String repeatGreeting, boolean hasSpoken,  Items reward) {
        this.name = name;
        this.greeting = greeting;
        this.repeatGreeting = repeatGreeting;
        this.hasSpoken = hasSpoken;
        this.rewardGiven = false;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        if(rewardGiven) {
            return repeatGreeting;
        }
        else  {
            return greeting;
        }
    }

    public Items getReward(){
        return reward;
    }

    public boolean isRewardGiven() {
        return rewardGiven;
    }

    public void setRewardGiven(boolean rewardGiven) {
        this.rewardGiven = rewardGiven;
    }
}