public class NPC {
    private String name;
    private String greeting;
    private String repeatGreeting;
    private boolean hasSpoken;

    public NPC(String name, String greeting, String repeatGreeting, boolean hasSpoken) {
        this.name = name;
        this.greeting = greeting;
        this.repeatGreeting = repeatGreeting;
        this.hasSpoken = hasSpoken;
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

    public boolean hasSpoken() {
        return hasSpoken;
    }
}