package Test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menutest extends JFrame {

    private static final long serialVersionUID = 1L;
    private boolean isMenuVisible = false;
    private JPanel contentPane;
    private JPanel menupanel;
    private JPanel profilepanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menutest frame = new menutest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public menutest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 713, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel wholepanel = new JPanel();
        wholepanel.setBounds(0, 0, 697, 388);
        contentPane.add(wholepanel);
        wholepanel.setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 697, 44);
        wholepanel.add(headerPanel);
        headerPanel.setLayout(null);

        menupanel = new JPanel();
        menupanel.setVisible(false);
        menupanel.setBackground(new Color(0, 128, 0));
        menupanel.setBounds(-1, 44, 120, 342);
        wholepanel.add(menupanel);
        menupanel.setLayout(null);

        JButton menubtn = new JButton("menu");
        menubtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isMenuVisible) {
                    menupanel.setVisible(false);
                    isMenuVisible = false;
                } else {
                    menupanel.setVisible(true);
                    isMenuVisible = true;
                }
            }
        });

        menupanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                menupanel.setVisible(false);
                isMenuVisible = false;
            }
        });

        menubtn.setBounds(12, 5, 63, 33);
        headerPanel.add(menubtn);

        JButton profilebtn = new JButton("profile");
        profilebtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                profilepanel.setVisible(true);
            }
        });
        profilebtn.setBounds(542, 8, 70, 31);
        headerPanel.add(profilebtn);

        profilepanel = new JPanel();
        profilepanel.setVisible(false);
        profilepanel.setBackground(new Color(0, 0, 255));
        profilepanel.setBounds(574, 42, 120, 127);
        wholepanel.add(profilepanel);
    }
}
