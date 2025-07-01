import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserLoginWithGui extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    public UserLoginWithGui() {
        setTitle("User Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // UI Components
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        statusLabel = new JLabel("");
        statusLabel.setForeground(Color.BLUE);
        add(statusLabel);

        // Action listener for login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/security_lab", "root", "");

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                statusLabel.setText("✅ Login Successful!");
                statusLabel.setForeground(new Color(0, 128, 0)); // Green
            } else {
                statusLabel.setText("❌ Login Failed!");
                statusLabel.setForeground(Color.RED);
            }

            conn.close();
        } catch (Exception ex) {
            statusLabel.setText("❌ Error: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLoginWithGui());
    }
}
