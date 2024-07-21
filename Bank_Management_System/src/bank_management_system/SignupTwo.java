package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel, selectAllButton;
    boolean selectAllSelected = false;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;

        // Label for the page title
        JLabel L1 = new JLabel("Page 2: Account Details");
        L1.setFont(new Font("Raleway", Font.BOLD, 22));
        L1.setBounds(200, 50, 300, 40);
        add(L1);

        // Label for account type
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 120, 200, 30);
        add(type);

        // Radio buttons for account types
        r1 = new JRadioButton("Saving");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 160, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 160, 150, 20);
        add(r2);

        r3 = new JRadioButton("Current");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 200, 150, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 200, 200, 20);
        add(r4);

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        // Label for card number
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 260, 200, 30);
        add(card);

        // Display of card number
        JLabel number = new JLabel("xxxx-xxxx-xxxx-2001");
        number.setFont(new Font("Raleway", Font.BOLD, 12));
        number.setBounds(330, 260, 300, 30);
        add(number);

        // Label for PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 330, 200, 30);
        add(pin);

        // Display of PIN number
        JLabel pinnum = new JLabel("xxxx");
        pinnum.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnum.setBounds(330, 330, 300, 30);
        add(pinnum);

        // Label for required services
        JLabel service = new JLabel("Required Services");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 410, 200, 30);
        add(service);

        // Checkboxes for required services
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        c1.setBounds(100, 450, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        c2.setBounds(350, 450, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        c3.setBounds(100, 500, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        c4.setBounds(350, 500, 200, 30);
        add(c4);

        c5 = new JCheckBox("SMS Alerts");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        c5.setBounds(100, 550, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        c6.setBounds(350, 550, 200, 30);
        add(c6);

        // Select All button for required services
        selectAllButton = new JButton("Select All");
        selectAllButton.setFont(new Font("Raleway", Font.BOLD, 14));
        selectAllButton.setBackground(Color.BLACK);
        selectAllButton.setForeground(Color.WHITE);
        selectAllButton.setBounds(100, 600, 120, 30);
        add(selectAllButton);

        // Declaration checkbox
        c7 = new JCheckBox("<html>I hereby declare that the above entered details are correct to the best of my knowledge.</html>");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.white);
        c7.setBounds(100, 650, 500, 50);
        add(c7);

        // Action listener for Select All button
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Toggle the selection state of all checkboxes
                if (!selectAllSelected) {
                    c1.setSelected(true);
                    c2.setSelected(true);
                    c3.setSelected(true);
                    c4.setSelected(true);
                    c5.setSelected(true);
                    c6.setSelected(true);
                    selectAllSelected = true;
                    selectAllButton.setText("Deselect All");
                } else {
                    c1.setSelected(false);
                    c2.setSelected(false);
                    c3.setSelected(false);
                    c4.setSelected(false);
                    c5.setSelected(false);
                    c6.setSelected(false);
                    selectAllSelected = false;
                    selectAllButton.setText("Select All");
                }
            }
        });

        // Submit and Cancel buttons
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 720, 100, 30);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        add(cancel);

        setSize(650, 820);
        setLocation(350, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;

            // Determine selected account type
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            } else {
                JOptionPane.showMessageDialog(null, "Please select an account type.");
                return;
            }

            // Generate random card number and PIN
            Random random = new Random();
            long cardNumber = Math.abs(random.nextLong() % 90000000) + 5040936000000000L;
            int pinNumber = Math.abs(random.nextInt() % 9000) + 1000;

            // Prepare selected facilities
            StringBuilder facilities = new StringBuilder();
            if (c1.isSelected()) {
                facilities.append("ATM Card, ");
            }
            if (c2.isSelected()) {
                facilities.append("Internet Banking, ");
            }
            if (c3.isSelected()) {
                facilities.append("Mobile Banking, ");
            }
            if (c4.isSelected()) {
                facilities.append("EMAIL Alerts, ");
            }
            if (c5.isSelected()) {
                facilities.append("SMS Alerts, ");
            }
            if (c6.isSelected()) {
                facilities.append("E-Statement, ");
            }

            // Remove trailing comma and space
            if (facilities.length() > 0) {
                facilities.setLength(facilities.length() - 2);
            }

            // Display generated card number, PIN, and selected facilities
            JOptionPane.showMessageDialog(null, "Form submitted successfully!\nAccount Type: " + accountType +
                    "\nCard Number: " + cardNumber + "\nPIN: " + pinNumber +
                    "\nSelected Facilities: " + facilities.toString());

            // Insert into database
            try {
                Conn conn = new Conn();
                String query = "insert into signuptwo values ('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facilities.toString() + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data inserted successfully.");

                setVisible(false);
                new SignupTwo(formno).setVisible(true); // Reset the form

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new SignupTwo(""); // Replace "" with the actual form number if available
    }
}
