package main.java.string.class_problems;

import java.util.*;

public class UniqueLetterHunt {
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        sc.close();
    }
}