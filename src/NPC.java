public class NPC {
    private String name;
    private String greeting;
    private String repeatGreeting;
    private boolean hasSpoken;
    private Items reward;
    private boolean rewardGiven;

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

    public String getGreeting() {
        return greeting;
    }

    public String getRepeatGreeting() {
        return repeatGreeting;
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