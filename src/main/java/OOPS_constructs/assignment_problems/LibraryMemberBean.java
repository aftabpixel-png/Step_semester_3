package main.java.OOPS_constructs.assignment_problems;

class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    // No-argument constructor
    public LibraryMember() {

    }

    // Membership ID getter
    public String getMembershipId() {

        return membershipId;
    }

    // Membership ID setter
    // Works only on the first call
    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    // Name getter
    public String getName() {

        return name;
    }

    // Name setter
    public void setName(String name) {

        this.name = name;
    }

    // Premium member getter
    public boolean isPremiumMember() {

        return premiumMember;
    }

    // Premium member setter
    public void setPremiumMember(boolean premium) {

        this.premiumMember = premium;
    }

    // Write-only security answer
    public void setSecurityAnswer(String answer) {

        if (answer != null) {

            securityAnswer = Integer.toHexString(
                    answer.hashCode());
        }
    }
}

public class LibraryMemberBean {

    public static void main(String[] args) {

        LibraryMember member = new LibraryMember();

        member.setMembershipId("LIB-8841");

        member.setName("Priya Nair");

        member.setPremiumMember(true);

        System.out.println(
                member.getMembershipId());

        // Second call is ignored
        member.setMembershipId("FAKE-0000");

        System.out.println(
                member.getMembershipId());

        System.out.println(
                member.isPremiumMember());

        // Security answer can be set,
        // but there is deliberately no getter.
        member.setSecurityAnswer(
                "BlueMountain");
    }
}
