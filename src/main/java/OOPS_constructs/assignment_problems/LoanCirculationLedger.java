package main.java.OOPS_constructs.assignment_problems;

class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId,
            String[] bookIds) {

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() {

        // Defensive copy
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(
            int index,
            String newId) {

        // Copy original array
        String[] correctedBooks = bookIds.clone();

        // Modify the copy
        correctedBooks[index] = newId;

        // Return a new object
        return new LoanReceipt(
                memberId,
                correctedBooks);
    }
}

class ReferenceOnlyLoanReceipt
        extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);

        this.roomNumber = roomNumber;
    }
}

class CirculationLedger {

    private static String branchCode;

    // Static block
    static {
        branchCode = "PT-BRANCH-01";
    }

    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {

                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {

                referenceOnly++;

            } else {

                regular++;
            }
        }

        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + referenceOnly
                + " reference-only | "
                + regular
                + " regular";
    }
}

public class LoanCirculationLedger {

    public static void main(String[] args) {

        // Test defensive copying
        LoanReceipt receipt = new LoanReceipt(
                "LIB-8841",
                new String[] {
                        "BK-100",
                        "BK-101"
                });

        String[] ids = receipt.getBookIds();

        ids[0] = "HACKED";

        System.out.println(
                receipt.getBookIds()[0]);

        // Test with-style correction
        LoanReceipt corrected = receipt.withCorrectedBookId(
                1,
                "BK-102");

        System.out.println(
                java.util.Arrays.toString(
                        receipt.getBookIds()));

        System.out.println(
                java.util.Arrays.toString(
                        corrected.getBookIds()));

        // Test nightly circulation
        LoanReceipt[] receipts = {

                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[] { "BK-200" },
                        "Reading Room 3"),

                null,

                new LoanReceipt(
                        "LIB-002",
                        new String[] { "BK-201" })
        };

        System.out.println(
                CirculationLedger
                        .processNightlyCirculation(receipts));
    }
}
