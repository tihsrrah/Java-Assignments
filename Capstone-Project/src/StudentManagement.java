import java.util.Scanner;

public class StudentManagement {

    private StudentDAO dao;
    private Scanner sc;

    public StudentManagement() {
        dao = new StudentDAO();
        sc = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("\nThank you for using the Student Management System!");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    private void addStudent() {

        System.out.println("\n----- Add Student -----");

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Student student = new Student(id, name, age, course, email);

        dao.addStudent(student);
    }

    private void searchStudent() {

        System.out.print("\nEnter Student ID: ");
        int id = sc.nextInt();

        dao.searchStudent(id);
    }

    private void updateStudent() {

        System.out.println("\n----- Update Student -----");

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        Student student = new Student(id, name, age, course, email);

        dao.updateStudent(student);
    }

    private void deleteStudent() {

        System.out.print("\nEnter Student ID to Delete: ");
        int id = sc.nextInt();

        dao.deleteStudent(id);
    }
}
