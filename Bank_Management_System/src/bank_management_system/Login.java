package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(new BorderLayout()); // Using BorderLayout instead of null layout

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logo
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image scaledImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        add(logoLabel, BorderLayout.NORTH);

        // Center panel for input fields and buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); // Using null layout for specific positioning within this panel
        centerPanel.setBackground(Color.WHITE);

        // Welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        centerPanel.add(text);

        // Card number field
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 18));
        cardno.setBounds(120, 150, 400, 40);
        centerPanel.add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(cardTextField);

        // PIN field
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(120, 220, 250, 30);
        centerPanel.add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(pinTextField);

        // Sign in button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        centerPanel.add(login);

        // Sign up button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        centerPanel.add(signup);

        // Clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        centerPanel.add(clear);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            try {
                Conn conn = new Conn();
                String cardnumber = cardTextField.getText();
                String pinnumber = new String(pinTextField.getPassword());
                String query = "INSERT INTO login (formno, cardnumber, pin) VALUES (?, ?, ?)";

                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, "SomeFormNo"); // Replace with the actual form number
                pstmt.setString(2, cardnumber);
                pstmt.setString(3, pinnumber);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Login details added successfully");
                } else {
                    System.out.println("Failed to add login details");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}
