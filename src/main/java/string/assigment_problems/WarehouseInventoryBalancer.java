import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;

        for (int val : sectionA)
            totalA += val;
        for (int val : sectionB)
            totalB += val;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestQty = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + highestQty +
                " (" + highestSection + ", Item " + highestIndex + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items per section: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter " + n + " quantities for Section A:");
        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter " + n + " quantities for Section B:");
        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}