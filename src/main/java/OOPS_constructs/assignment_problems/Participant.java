package main.java.OOPS_constructs.assignment_problems;

public class Participant {
    String name, teamName;
    boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public static void main(String[] args) {
        String[] names = { "Ravi", "Meera", "Karthik", "Divya" };
        String[] teamNames = { "ByteBusters", "", "CodeCrafters", "" };

        for (int i = 0; i < names.length; i++) {
            Participant p = teamNames[i].isEmpty() ? new Participant(names[i])
                    : new Participant(names[i], teamNames[i]);
            p.printStatus();
        }
    }
}
