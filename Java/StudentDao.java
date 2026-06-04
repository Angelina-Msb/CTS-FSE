import java.sql.*;

public class StudentDao {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void insertStudent(int id, String name, int age) {
        String query = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(int id, String name, int age) {
        String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record updated");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}