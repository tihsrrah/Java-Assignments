import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {

        employees.add(emp);
    }

    public void displayEmployees() {

        if (employees.isEmpty()) {

            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees)
            System.out.println(emp);
    }

    public void saveToFile() {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt"));

            for (Employee emp : employees) {

                bw.write(emp.toFileString());
                bw.newLine();
            }

            bw.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("File Error.");
        }
    }

    public void loadFromFile() {

        employees.clear();

        try {

            BufferedReader br = new BufferedReader(new FileReader("employees.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Employee emp = new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]));

                employees.add(emp);
            }

            br.close();

            System.out.println("Data loaded successfully.");

        } catch (IOException e) {

            System.out.println("No saved file found.");
        }
    }
}
