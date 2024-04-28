package gui;

import controller.SignUpController;
import helper.Helper;
import models.Address;
import models.User;

import javax.swing.*;
import java.awt.*;

public class SignupPage extends JFrame {
    private JLabel signupLabel;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordTextField;
    private JButton registerButton;
    private JTextField firstNameTextField;
    private JLabel firstNameLabel;
    private JTextField lastNameTextField;
    private JLabel lastNameLabel;
    private JTextField countryTextField;
    private JLabel countryLabel;
    private JTextField cityTextField;
    private JLabel cityLabel;
    private JTextField postalCodeTextField;
    private JLabel postalCodeLabel;

    public SignupPage() {
        super("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(420, 550);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }
    private void initComponents() {

        // first name label
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        firstNameLabel.setForeground(Color.GRAY);
        firstNameLabel.setBounds(40 , 40, 80, 10);
        add(firstNameLabel);

        // first name text field
        firstNameTextField  = new JTextField();
        firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        firstNameTextField.setForeground(Color.DARK_GRAY);
        firstNameTextField.setBackground(Color.WHITE);
        firstNameTextField.setBounds(37 , 55, 168, 30);
        add(firstNameTextField);

        // last name label
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lastNameLabel.setForeground(Color.GRAY);
        lastNameLabel.setBounds(215 , 40, 80, 10);
        add(lastNameLabel);

        // last name text field
        lastNameTextField  = new JTextField();
        lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lastNameTextField.setForeground(Color.DARK_GRAY);
        lastNameTextField.setBackground(Color.WHITE);
        lastNameTextField.setBounds(213 , 55, 168, 30);
        add(lastNameTextField);

        // username label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        usernameLabel.setForeground(Color.GRAY);
        usernameLabel.setBounds(40 , 110, 80, 10);
        add(usernameLabel);

        // username text field
        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        usernameTextField.setForeground(Color.DARK_GRAY);
        usernameTextField.setBounds(37 , 125, 346, 30);
        usernameTextField.setBackground(Color.WHITE);
        add(usernameTextField);

        // email label
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        emailLabel.setForeground(Color.GRAY);
        emailLabel.setBounds(40 , 180, 80, 10);
        add(emailLabel);

        // email text field
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        emailTextField.setForeground(Color.DARK_GRAY);
        emailTextField.setBounds(37 , 195, 346, 30);
        emailTextField.setBackground(Color.WHITE);
        add(emailTextField);

        // country label
        countryLabel = new JLabel("Country");
        countryLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        countryLabel.setForeground(Color.GRAY);
        countryLabel.setBounds(40 , 249, 81, 15);
        add(countryLabel);

        // country text field
        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        countryTextField.setForeground(Color.DARK_GRAY);
        countryTextField.setBackground(Color.WHITE);
        countryTextField.setBounds(37 , 265, 112, 30);
        add(countryTextField);

        // city label
        cityLabel = new JLabel("City");
        cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        cityLabel.setForeground(Color.GRAY);
        cityLabel.setBounds(154 , 249, 80, 15);
        add(cityLabel);

        // city text field
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        cityTextField.setForeground(Color.DARK_GRAY);
        cityTextField.setBackground(Color.WHITE);
        cityTextField.setBounds(151 , 265, 112, 30);
        add(cityTextField);

        // postal code label
        postalCodeLabel = new JLabel("Postal Code");
        postalCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        postalCodeLabel.setForeground(Color.GRAY);
        postalCodeLabel.setBounds(268 , 249, 80, 15);
        add(postalCodeLabel);

        // postal code text field
        postalCodeTextField = new JTextField();
        postalCodeTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        postalCodeTextField.setForeground(Color.DARK_GRAY);
        postalCodeTextField.setBackground(Color.WHITE);
        postalCodeTextField.setBounds(265 , 265, 112, 30);
        add(postalCodeTextField);


        // password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setBounds(40 , 315, 112, 10);
        add(passwordLabel);

        // password text field
        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        passwordTextField.setForeground(Color.DARK_GRAY);
        passwordTextField.setBounds(37 , 330, 346, 30);
        passwordTextField.setBackground(Color.WHITE);
        add(passwordTextField);

        // confirm password label
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        confirmPasswordLabel.setForeground(Color.GRAY);
        confirmPasswordLabel.setBounds(40 , 385, 110, 10);
        add(confirmPasswordLabel);

        // confirm password text field
        confirmPasswordTextField = new JPasswordField();
        confirmPasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        confirmPasswordTextField.setForeground(Color.DARK_GRAY);
        confirmPasswordTextField.setBounds(37 , 400, 346, 30);
        confirmPasswordTextField.setBackground(Color.WHITE);
        add(confirmPasswordTextField);

        // register button
        registerButton = new JButton("Sign Up");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        registerButton.setForeground(Color.DARK_GRAY);
        registerButton.setBounds(170 , 450, 80, 40);
        registerButton.setBackground(Color.WHITE);
        registerButton.addActionListener(e -> {
            if (Helper.isFieldEmpty(firstNameTextField, lastNameTextField, usernameTextField, postalCodeTextField, countryTextField, cityTextField, passwordTextField, confirmPasswordTextField)) {
                Helper.showMessage("fill");
            } else if (!Helper.isValidEmail(emailTextField)) {
                Helper.showMessage("wrong email", "Please enter a valid email");
            } else if (!Helper.isValidPostalCode(postalCodeTextField.getText())) {
                Helper.showMessage("wrong postal code", "Please enter a valid postal code! It must contain 5 digits");
            } else if (!new String(passwordTextField.getPassword()).equals(new String(confirmPasswordTextField.getPassword()))) {
                Helper.showMessage("wrong password", "Passwords do not match!");
            } else {
                // if all valid create user and start sign up
                User user = new User();
                user.setUserName(usernameTextField.getText());
                user.setEmail(emailTextField.getText());
                user.setPassword(new String(passwordTextField.getPassword()));
                user.setFirstName(firstNameTextField.getText());
                user.setLastName(lastNameTextField.getText());
                user.setPhone(null);


                // store address at database
                Address adress = new Address();
                adress.setCountry(countryTextField.getText());
                adress.setCity(cityTextField.getText());
                adress.setPostalCode(postalCodeTextField.getText());

                // store address id after saving it
                int address_id = SignUpController.saveAddressToDatabase(adress);
                System.out.println(address_id);
                // add address to user
                user.setAddress_id(address_id);

                // store user to database
                if(SignUpController.saveUserToDatabase(user)) {
                    System.out.println("user signed up");
                    Helper.showMessage("Signed up successfully", "Login to your account!");
                    this.dispose();
                }
                else{
                    Helper.showMessage("User could not be signed up!", "Please try again");
                }
            }
        });
        add(registerButton);
    }
}
