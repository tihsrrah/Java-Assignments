import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.addBook(new Book("Java Programming"));
        library.addBook(new Book("Data Structures"));
        library.addBook(new Book("Operating Systems"));

        int choice;

        do {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String borrow = sc.nextLine();
                    library.borrowBook(borrow);
                    break;

                case 3:
                    System.out.print("Enter book title: ");
                    String ret = sc.nextLine();
                    library.returnBook(ret);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
