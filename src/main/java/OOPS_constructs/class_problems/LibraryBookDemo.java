public class LibraryBookDemo {
    static class LibraryBook {
        String title;
        String isbn;
        boolean catalogued;

        LibraryBook(String title, String isbn) {
            this.title = title;
            this.isbn = (isbn == null || isbn.isEmpty()) ? "PENDING" : isbn;
            this.catalogued = true;
        }

        LibraryBook(String title) {
            this(title, "");
        }

        void printStatus() {
            System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
        }
    }

    public static void main(String[] args) {
        String[] titles = { "Clean Code", "Untitled Draft", "1984", "Notes" };
        String[] isbns = { "978-0132350884", "", "9780451524935", "" };

        LibraryBook[] books = new LibraryBook[titles.length];
        for (int i = 0; i < titles.length; i++) {
            if (isbns[i].isEmpty()) {
                books[i] = new LibraryBook(titles[i]);
            } else {
                books[i] = new LibraryBook(titles[i], isbns[i]);
            }
        }

        for (LibraryBook book : books) {
            book.printStatus();
        }
    }
}
