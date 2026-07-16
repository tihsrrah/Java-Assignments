public class Library {

    private Book[] books = new Book[10];
    private int count = 0;

    public void addBook(Book book) {
        books[count] = book;
        count++;
        System.out.println(book.getTitle() + " added.");
    }

    public void borrowBook(String title) {

        for (int i = 0; i < count; i++) {

            if (books[i].getTitle().equalsIgnoreCase(title)) {

                if (books[i].isAvailable()) {
                    books[i].borrowBook();
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book already borrowed.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(String title) {

        for (int i = 0; i < count; i++) {

            if (books[i].getTitle().equalsIgnoreCase(title)) {

                books[i].returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void displayBooks() {

        System.out.println("\nLibrary Books:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    books[i].getTitle() +
                    " - " +
                    (books[i].isAvailable() ? "Available" : "Borrowed"));
        }
    }
}
