package main.java.OOPS_constructs.assignment_problems;

class GymMember4 {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember4(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid Member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember4 extends GymMember4 {
    private String trainerName;

    public PremiumMember4(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName
                + " | Sessions: " + sessionsAttended;
    }
}

public class Problem4 {

    static String batchPrint(GymMember4[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember4 member : members) {
            if (result.length() > 0) {
                result.append(" | ");
            }

            // Polymorphic method call
            result.append(member.displayInfo());

            // Safe downcasting
            if (member instanceof PremiumMember4) {
                PremiumMember4 premium = (PremiumMember4) member;

                result.append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("]");
            }
        }

        if (result.length() > 0) {
            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMember4[] members = {
                new GymMember4("MEM6", 1000),
                new PremiumMember4("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}
