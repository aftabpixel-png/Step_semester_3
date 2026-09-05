package main.java.OOPS_constructs.assignment_problems;

class Payment {
    double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}

class CardPayment extends Payment {
    double payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}

public class CanteenPOS {
    static double totalCollected = 0;

    static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cp = (CardPayment) payment;
            totalCollected += cp.payWithProcessingFee(amount);
        } else {
            totalCollected += payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(), new Payment(), new CardPayment(),
            new Payment(), new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        for (int i = 0; i < payments.length; i++) {
            processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + totalCollected);
    }
}
