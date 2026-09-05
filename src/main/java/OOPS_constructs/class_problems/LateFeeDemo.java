public class LateFeeDemo {
    static class Account {
        final double calculateLateFee(int daysLate) {
            return daysLate * 0.05 * getBaseUnit();
        }

        double getBaseUnit() {
            return 0;
        }

        final void printSummary(String regNo, double totalFee, int daysLate) {
            if (daysLate <= 0) {
                System.out.println(regNo + " - On time, no late fee");
                return;
            }
            double lateFee = totalFee * 0.001 * daysLate;
            System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
        }
    }

    public static void main(String[] args) {
        String[] regNos = { "RA001", "RA002", "RA003", "RA004" };
        double[] totalFees = { 200000, 150000, 180000, 220000 };
        int[] daysLate = { 10, 0, -2, 5 };

        Account account = new Account();
        for (int i = 0; i < regNos.length; i++) {
            account.printSummary(regNos[i], totalFees[i], daysLate[i]);
        }
    }
}