import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager = new EmployeeManager();

        int choice;

        do {

            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            try {

                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        manager.addEmployee(
                                new Employee(id, name, dept, salary));

                        break;

                    case 2:
                        manager.displayEmployees();
                        break;

                    case 3:
                        manager.saveToFile();
                        break;

                    case 4:
                        manager.loadFromFile();
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {

                System.out.println("Invalid Input.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}
