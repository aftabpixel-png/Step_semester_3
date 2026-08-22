package main.java.string.class_problems;

import java.util.Scanner;

public class WordLengthFinder {
    static String[] findShortestAndLongestWord(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = cleaned.trim().split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length())
                shortest = word;
            if (word.length() > longest.length())
                longest = word;
        }

        return new String[] { shortest, longest };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] result = findShortestAndLongestWord(text);
        String shortest = result[0];
        String longest = result[1];

        System.out.println("Shortest: \"" + shortest + "\" (" + shortest.length() + ") | Longest: \"" +
                longest + "\" (" + longest.length() + ")");

        sc.close();
    }
}
