package codes;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel usernamelbl;
    private JLabel passwordlbl;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisplayFrame frame = new DisplayFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DisplayFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 574, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 558, 365);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel usernamedisplayLBL = new JLabel("Username :");
        usernamedisplayLBL.setToolTipText("");
        usernamedisplayLBL.setBounds(53, 111, 91, 38);
        panel.add(usernamedisplayLBL);

        JLabel passworddisplayLBL = new JLabel("Password :");
        passworddisplayLBL.setToolTipText("");
        passworddisplayLBL.setBounds(51, 168, 91, 38);
        panel.add(passworddisplayLBL);

        usernamelbl = new JLabel("");
        usernamelbl.setBounds(129, 125, 100, 14); // Increase width to display longer usernames
        panel.add(usernamelbl);

        passwordlbl = new JLabel("");
        passwordlbl.setBounds(129, 178, 100, 14); // Increase width to display longer passwords
        panel.add(passwordlbl);

        // Fetch data from the database and update labels
        fetchDataAndUpdateLabels();
    }

    private void fetchDataAndUpdateLabels() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-FEGPR4D\\SQLEXPRESS;databaseName=testDB;integratedSecurity=true;encrypt=false;";
            Connection conn = DriverManager.getConnection(url);

            // Use a prepared statement to avoid SQL injection
            String query = "SELECT * FROM accTest WHERE userName = ? AND password = ?"; // Modify with your condition
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Assuming you have userID, userName, and password variables initialized
                pstmt.setString(1, "admin1"); // Replace with the actual username you want to retrieve
                pstmt.setString(2, "admin2"); // Replace with the actual password you want to retrieve

                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    // Update labels with data from the result set
                    usernamelbl.setText(resultSet.getString("userName")); // Replace "userName" with your actual column name
                    passwordlbl.setText(resultSet.getString("password")); // Replace "password" with your actual column name
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
