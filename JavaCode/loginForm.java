package Test;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class loginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailtxtField;
    private JLabel usernamelbl;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	loginForm frame = new loginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 561, 403);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        emailtxtField = new JTextField();
        emailtxtField.setBounds(194, 110, 238, 45);
        contentPane.add(emailtxtField);
        emailtxtField.setColumns(10);

        usernamelbl = new JLabel("USERNAME");
        usernamelbl.setBounds(69, 124, 83, 26);
        contentPane.add(usernamelbl);

        JLabel lblNewLabel = new JLabel("PASSWORD");
        lblNewLabel.setBounds(67, 201, 74, 35);
        contentPane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(197, 192, 236, 41);
        contentPane.add(passwordField);

        JButton loginBTN = new JButton("LOGIN");
        loginBTN.setBounds(242, 276, 89, 23);
        contentPane.add(loginBTN);

        // Add action listener to the login button
        loginBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the entered username and password
                String enteredUsername = emailtxtField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                // Perform authentication by querying the database
                if (authenticateUser(enteredUsername, enteredPassword)) {
                    // Successful login
                    JOptionPane.showMessageDialog(contentPane, "Login Successful!");
                } else {
                    // Failed login
                    JOptionPane.showMessageDialog(contentPane, "Login Failed! Please try again.");
                }
            }
        });
    }

    // Function to authenticate user by querying the database
    private boolean authenticateUser(String username, String password) {
        try {
            String url = "jdbc:sqlserver://DESKTOP-FEGPR4D\\SQLEXPRESS;databaseName=testDB;integratedSecurity=true;encrypt=false;";
            Connection conn = DriverManager.getConnection(url);

            // Use a prepared statement to avoid SQL injection
            String query = "SELECT * FROM accTest WHERE userName = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet resultSet = pstmt.executeQuery();

                // If resultSet.next() returns true, it means a matching user was found
                return resultSet.next();
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
