package main.java.OOPS_constructs.class_problems;

class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
        this.name = "";
        this.confirmed = false;
    }

    // Constructor with name
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {

        if (otp != null && otp.matches("\\d{4,6}")) {
            this.otp = otp;
        }
    }
}

public class MovieBookingProfileDemo {

    public static void main(String[] args) {

        MovieBookingProfile profile = new MovieBookingProfile("Rahul Dev");

        System.out.println(
                profile.getName());

        profile.setConfirmed(true);

        System.out.println(
                profile.isConfirmed());

        profile.setOtp("4471");
    }
}
