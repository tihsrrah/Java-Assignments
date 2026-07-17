import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {

        String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)
        ) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getEmail());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nStudent Added Successfully!\n");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View All Students
    public void viewStudents() {

        String query = "SELECT * FROM students";

        try (
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query)
        ) {

            ArrayList<Student> list = new ArrayList<>();

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                );

                list.add(s);
            }

            if (list.isEmpty()) {
                System.out.println("\nNo Students Found.\n");
            } else {

                System.out.println("\n===== STUDENT LIST =====");

                for (Student s : list) {
                    System.out.println(s);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Student
    public void searchStudent(int id) {

        String query = "SELECT * FROM students WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                );

                System.out.println("\nStudent Found\n");
                System.out.println(s);

            } else {

                System.out.println("\nStudent Not Found.\n");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    // Update Student
    public void updateStudent(Student student) {

        String query =
                "UPDATE students SET name=?, age=?, course=?, email=? WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)
        ) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nStudent Updated Successfully!\n");
            else
                System.out.println("\nStudent ID Not Found.\n");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("\nStudent Deleted Successfully!\n");
            else
                System.out.println("\nStudent ID Not Found.\n");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
}
