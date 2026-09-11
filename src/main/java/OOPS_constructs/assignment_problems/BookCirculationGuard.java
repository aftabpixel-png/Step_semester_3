package main.java.OOPS_constructs.assignment_problems;

class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {

        if (copiesTotal <= 0) {
            throw new IllegalArgumentException(
                    "copiesTotal must be positive");
        }

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {

        return copiesAvailable;
    }
}

public class BookCirculationGuard {

    public static void main(String[] args) {

        BookInventory book = new BookInventory(3);

        // Three successful checkouts
        book.checkOut();
        book.checkOut();
        book.checkOut();

        // Fourth checkout rejected
        book.checkOut();

        System.out.println(
                book.getCopiesAvailable());

        // Three successful check-ins
        book.checkIn();
        book.checkIn();
        book.checkIn();

        // Fourth check-in rejected
        book.checkIn();

        System.out.println(
                book.getCopiesAvailable());
    }
}
