package main.java.OOPS_constructs.assignment_problems;

import java.util.Arrays;

class GymMember3 {
    protected String memberId;
    protected int monthlyFee;

    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public GymMember3(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid Member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        if (feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    public int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < feeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }
}

class PremiumMember3 extends GymMember3 {
    private String trainerName;

    public PremiumMember3(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        PremiumMember3 p = new PremiumMember3("MEM5", 2000, "Coach Riya");

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}