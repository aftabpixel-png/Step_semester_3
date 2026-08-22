import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}