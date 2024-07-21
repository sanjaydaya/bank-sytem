package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdraw, fastCash, ministatement, pinchange, balanceInquiry, exit;
    
    Transactions() {
        setLayout(null);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Adding text label for transaction prompt
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210, 300, 700, 35); // Adjusted position and size
        text.setFont(new Font("Arial", Font.BOLD, 20)); // Adjusted font
        text.setForeground(Color.WHITE); // Adjusted foreground color
        image.add(text); // Adding label to the image (background)

        // Buttons for transactions
        deposit = new JButton("Deposit");
        deposit.setBounds(190, 415, 120, 30);
        deposit.addActionListener(this);
        image.add(deposit);
       

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 415, 120, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(190, 450, 120, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 120, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(190, 485, 120, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBounds(355, 485, 120, 30);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit = new JButton("Exit");
        exit.setBounds(190, 520, 285, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }

    public static void main(String arg[]) {
        new Transactions();
    }

   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
        System.exit(0);
        }
   
    }
}
