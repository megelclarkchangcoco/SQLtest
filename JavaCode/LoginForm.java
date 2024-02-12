package LoginFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel passwordfieldPanel;
    private JPanel usernametextfieldPanel;
    private JPanel cardPanel;
    private JPanel signbtnpanel;
    private CardLayout cardLayout;
    private JTextField usernametextField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginForm frame = new LoginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 771, 506);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(424, 0, 330, 467);
        contentPane.add(cardPanel);

        JPanel employeeLoginPanel = new JPanel();
        employeeLoginPanel.setBackground(new Color(120, 182, 50));
        cardPanel.add(employeeLoginPanel, "Employee");
        employeeLoginPanel.setLayout(null);

        JButton Employeebtn = new JButton("Employee");
        Employeebtn.setForeground(new Color(255, 255, 255));
        Employeebtn.setFont(new Font("Inter", Font.PLAIN, 12));
        Employeebtn.setBounds(78, 133, 89, 23);
        Employeebtn.setOpaque(false);
        Employeebtn.setContentAreaFilled(false);
        Employeebtn.setBorderPainted(false);
        Employeebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Employee");
            }
        });
        employeeLoginPanel.add(Employeebtn);

        JButton Adminbtn = new JButton("Admin");
        Adminbtn.setForeground(new Color(255, 255, 255));
        Adminbtn.setBackground(new Color(255, 255, 255));
        Adminbtn.setFont(new Font("Inter", Font.PLAIN, 12));
        Adminbtn.setBounds(177, 133, 89, 23);
        Adminbtn.setOpaque(false);
        Adminbtn.setContentAreaFilled(false);
        Adminbtn.setBorderPainted(false);
        Adminbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Admin");
            }
        });
        employeeLoginPanel.add(Adminbtn);
        
         passwordfieldPanel = new RoundedJPanel();
         passwordfieldPanel.setOpaque(false);
        passwordfieldPanel.setBackground(new Color(120, 182, 50));
        passwordfieldPanel.setBounds(47, 180, 249, 54);
        employeeLoginPanel.add(passwordfieldPanel);
        passwordfieldPanel.setLayout(null);
        
        usernametextField = new RoundedTextField();
        usernametextField.setOpaque(false);
        usernametextField.setBounds(0, 0, 249, 54);
        passwordfieldPanel.add(usernametextField);
        usernametextField.setColumns(10);
        
        usernametextfieldPanel = new RoundedJPanel();
        usernametextfieldPanel.setOpaque(false);
        usernametextfieldPanel.setBackground(new Color(120, 182, 50));
        usernametextfieldPanel.setBounds(47, 257, 249, 54);
        employeeLoginPanel.add(usernametextfieldPanel);
        usernametextfieldPanel.setLayout(null);
        
        passwordField = new RoundedPasswordField();
        passwordField.setOpaque(false);
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setBounds(0, 0, 249, 54);
        usernametextfieldPanel.add(passwordField);
        
        signbtnpanel = new RoundedJPanel();
        signbtnpanel.setOpaque(false);
        signbtnpanel.setBounds(110, 322, 129, 41);
        employeeLoginPanel.add(signbtnpanel);
        signbtnpanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        lblNewLabel.setBounds(41, 11, 60, 19);
        signbtnpanel.add(lblNewLabel);

        JPanel adminLoginPanel = new JPanel();
        adminLoginPanel.setBackground(new Color(0, 0, 255));
        cardPanel.add(adminLoginPanel, "Admin");
        adminLoginPanel.setLayout(null);

        JButton Employeebtn_1 = new JButton("Employee");
        Employeebtn_1.setBounds(71, 111, 89, 23);
        Employeebtn_1.setOpaque(false);
        Employeebtn_1.setContentAreaFilled(false);
        Employeebtn_1.setBorderPainted(false);
        Employeebtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Employee");
            }
        });
        adminLoginPanel.add(Employeebtn_1);

        JButton Adminbtn_1 = new JButton("Admin");
        Adminbtn_1.setBounds(172, 111, 89, 23);
        Adminbtn_1.setOpaque(false);
        Adminbtn_1.setContentAreaFilled(false);
        Adminbtn_1.setBorderPainted(false);
        Adminbtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Admin");
            }
        });
        adminLoginPanel.add(Adminbtn_1);
    }
}
