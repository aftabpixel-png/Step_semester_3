package main.java.string.class_problems;

import java.util.Scanner;

public class VipCustomerChecker {
    static String validateCustomerId(String customerId) {
        if (customerId.startsWith("VIP-")) {
            return "VIP Customer";
        }
        return "Regular Customer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String id = sc.nextLine();
        System.out.println(validateCustomerId(id));
        sc.close();
    }
}
