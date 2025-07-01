import java.sql.*;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/security_lab", "root", ""
            );
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username='" + user + "' AND password='" + pass + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
