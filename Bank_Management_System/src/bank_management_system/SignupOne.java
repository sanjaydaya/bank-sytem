package bank_management_system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    long random;

    JLabel formno, PersonDetails, name, fname, dob, gender, marital, currentStatus, address, phoneno, email, city,
            state, pincode, idCard;
    JTextField nameTextField, fnameTextField, phoneTextField, emailTextField, addressTextField, cityTextField,
            stateTextField, pinTextField, idCardTextField;
    JRadioButton male, female, transgender, married, unmarried, other;
    JComboBox<String> statusComboBox;
    JButton next, cancel;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);

        Random ran = new Random();
        random = ran.nextInt(9000) + 1000; // Generate a random number between 1000 and 9999

        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        PersonDetails = new JLabel(" Personal Details");
        PersonDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        PersonDetails.setBounds(300, 80, 400, 30);
        add(PersonDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(nameTextField);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fnameTextField);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);

        idCard = new JLabel("ID Card:");
        idCard.setFont(new Font("Raleway", Font.BOLD, 20));
        idCard.setBounds(100, 290, 200, 30);
        add(idCard);
        idCardTextField = new JTextField();
        idCardTextField.setBounds(300, 290, 400, 30);
        idCardTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(idCardTextField);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 340, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 340, 60, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 340, 120, 30);
        add(female);

        transgender = new JRadioButton("Other");
        transgender.setBounds(600, 340, 180, 30);
        add(transgender);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(transgender);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        currentStatus = new JLabel("Current Status:");
        currentStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        currentStatus.setBounds(100, 440, 200, 30);
        add(currentStatus);

        String[] statusOptions = { "Working", "Studying" };
        statusComboBox = new JComboBox<>(statusOptions);
        statusComboBox.setBounds(300, 440, 200, 30);
        add(statusComboBox);

        phoneno = new JLabel("Phone Number:");
        phoneno.setFont(new Font("Raleway", Font.BOLD, 20));
        phoneno.setBounds(100, 490, 200, 30);
        add(phoneno);
        phoneTextField = new JTextField();
        phoneTextField.setBounds(300, 490, 400, 30);
        phoneTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(phoneTextField);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 540, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 540, 400, 30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(emailTextField);

        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 590, 200, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 590, 400, 30);
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(addressTextField);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 640, 200, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 640, 400, 30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(cityTextField);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 690, 200, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 690, 400, 30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(stateTextField);

        pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 740, 200, 30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 740, 400, 30);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(670, 780, 80, 30);
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(580, 780, 80, 30);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to cancel? Any unsaved data will be lost.", "Confirm Cancel",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose(); // Close the frame
                }
            }
        });
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 900);
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""; // Assuming this is not used for database insert
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();

        // Retrieve the selected date from the JDateChooser and format it correctly
        java.util.Date selectedDate = dateChooser.getDate();
        String dob = ""; // Initialize DOB string
        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob = sdf.format(selectedDate);
        }

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (transgender.isSelected()) {
            gender = "Other";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String currentStatus = (String) statusComboBox.getSelectedItem();

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        String phoneno = phoneTextField.getText();
        String idCard = idCardTextField.getText(); // Retrieve ID card information

        try {
            StringBuilder errorMessage = new StringBuilder("Please correct the following errors:\n\n");
            boolean isValid = true;

            if (name.isEmpty()) {
                errorMessage.append("- Name is required.\n");
                isValid = false;
            }

            if (fname.isEmpty()) {
                errorMessage.append("- Father's Name is required.\n");
                isValid = false;
            }

            if (dob.isEmpty()) {
                errorMessage.append("- Date of Birth is required.\n");
                isValid = false;
            }

            if (gender == null) {
                errorMessage.append("- Gender is required.\n");
                isValid = false;
            }

            if (email.isEmpty()) {
                errorMessage.append("- Email Address is required.\n");
                isValid = false;
            } else if (!isValidEmail(email)) {
                errorMessage.append("- Invalid Email Address.\n");
                isValid = false;
            }

            if (marital == null) {
                errorMessage.append("- Marital Status is required.\n");
                isValid = false;
            }

            if (address.isEmpty()) {
                errorMessage.append("- Address is required.\n");
                isValid = false;
            }

            if (city.isEmpty()) {
                errorMessage.append("- City is required.\n");
                isValid = false;
            }

            if (state.isEmpty()) {
                errorMessage.append("- State is required.\n");
                isValid = false;
            }

            if (pin.isEmpty()) {
                errorMessage.append("- Pin Code is required.\n");
                isValid = false;
            }

            if (phoneno.isEmpty()) {
                errorMessage.append("- Phone Number is required.\n");
                isValid = false;
            } else if (!isValidPhoneNumber(phoneno)) {
                errorMessage.append("- Invalid Phone Number. Please enter a 10-digit phone number.\n");
                isValid = false;
            }

            if (idCard.isEmpty()) {
                errorMessage.append("- ID Card information is required.\n");
                isValid = false;
            }

            if (isValid) {
                // Database operation here (replace with your database connection logic)
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob
                        + "', '" + gender + "', '" + marital + "', '" + currentStatus + "', '" + address + "', '"
                        + phoneno + "', '" + email + "', '" + city + "', '" + state + "', '" + pin + "', '" + idCard
                        + "')";
                c.s.executeUpdate(query); // This needs proper error handling for SQL exceptions

                // Successful message (replace with your logic)
             

                // Optionally, clear the form after successful submission
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                clearForm();

            } else {
                JOptionPane.showMessageDialog(null, errorMessage.toString(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(),
                    "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        // Clear all form fields after successful submission
        nameTextField.setText("");
        fnameTextField.setText("");
        dateChooser.setDate(null);
        idCardTextField.setText("");
        male.setSelected(false);
        female.setSelected(false);
        transgender.setSelected(false);
        married.setSelected(false);
        unmarried.setSelected(false);
        other.setSelected(false);
        statusComboBox.setSelectedIndex(0);
        phoneTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        pinTextField.setText("");
        // Optionally, set focus on the first field or reset form state
    }

    private boolean isValidEmail(String email) {
        // Basic email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Basic phone number validation
        String phoneRegex = "\\d{10}";
        return phoneNumber.matches(phoneRegex);
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
