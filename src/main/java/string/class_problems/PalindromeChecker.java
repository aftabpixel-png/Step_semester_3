package main.java.string.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1)
            return true;
        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = text.toCharArray();

        int left = 0, right = reversed.length - 1;
        while (left < right) {
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
            left++;
            right--;
        }
        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String iterResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterResult + " | Recursive: " + recResult +
                " | Array Reversal: " + arrResult);

        sc.close();
    }
}