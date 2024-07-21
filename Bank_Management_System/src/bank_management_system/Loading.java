package bank_management_system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame {
  JProgressBar progressBar;
  Timer timer;

  public Loading() {
    setTitle("Welcome");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // Assuming the "Icons" folder is inside the "resources" folder within your project
    ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));

    JLabel logoLabel = new JLabel(logoIcon);
    logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    progressBar = new JProgressBar(0, 100);
    progressBar.setStringPainted(true);
    progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Set preferred size and minimum size to make the progress bar smaller
    Dimension prefSize = progressBar.getPreferredSize();
    prefSize.width = 200; // Adjust width as desired
    prefSize.height = 10; // Set the desired height
    progressBar.setPreferredSize(prefSize);
    progressBar.setMinimumSize(new Dimension(prefSize.width, prefSize.height));

    JLabel loadingLabel = new JLabel("Loading...");
    loadingLabel.setFont(new Font("Arial", Font.BOLD, 18));
    loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(logoLabel);
    panel.add(Box.createVerticalStrut(20)); // Add some spacing between components
    panel.add(progressBar);
    panel.add(Box.createVerticalStrut(10)); // Add some more spacing
    panel.add(loadingLabel);

    getContentPane().add(panel);
    setSize(500, 500); // Set the frame size to 500x500
    setLocationRelativeTo(null); // Center the frame on the screen
    setVisible(true);

    timer = new Timer(100, e -> {
      int value = progressBar.getValue();
      if (value < 100) {
        progressBar.setValue(value + 1);
      } else {
        timer.stop();
        setVisible(false);
        new Login().setVisible(true); // Open login page after loading
      }
    });
    timer.start();
  }

  public static void main(String[] args) {
    new Loading();
  }
}
