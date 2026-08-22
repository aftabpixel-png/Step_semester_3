import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, original.length(), accuracy);

        if (firstMismatchPos == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + firstMismatchPos +
                    " ('" + origChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must be of equal length.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}