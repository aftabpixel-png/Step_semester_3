public class AccountBatchPaymentDemo {
    static class FeeAccount {
        String id;

        FeeAccount(String id) {
            this.id = id;
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        HostelFeeAccount(String id) {
            super(id);
        }
    }

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
                new HostelFeeAccount("H-01"),
                new HostelFeeAccount("H-02"),
                new FeeAccount("D-01"),
                new FeeAccount("D-02")
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println(
                "Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}