package gui;

import helper.Helper;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {
    private JLabel appTitle;
    private JLabel welcomeMessage;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JLabel forgotPassword;
    private JLabel signup;
    private JLabel welcomeImage;
    private JLabel imageMessage;
    private JLabel usernameLabel;
    private JLabel passwordLabel;


    public LoginPage() {
        // set frame settings
        super("Welcome!");
        setSize(1000, 660);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }
    private void initComponents() {
        // welcome image
        welcomeImage = new JLabel(Helper.loadImageIcon("src/main/images/login-book.png"));
        welcomeImage.setBounds(90,135, 350, 330);
        add(welcomeImage);

        // image message
        imageMessage = new JLabel("Add your contacts to your lists!");
        imageMessage.setBounds(180,475, 200, 30);
        imageMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        imageMessage.setForeground(Color.GRAY);
        add(imageMessage);

        // app title
        appTitle = new JLabel("Phone Book");
        appTitle.setBounds(690, 65, 150, 30);
        appTitle.setFont(new Font("Tahoma", Font.ITALIC, 24));
        appTitle.setForeground(Color.darkGray);
        add(appTitle);

        // welcome message
        welcomeMessage = new JLabel("Welcome to Phone Book");
        welcomeMessage.setBounds(637, 110, 250, 90);
        welcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        welcomeMessage.setForeground(Color.GRAY);
        add(welcomeMessage);

        // username label
        usernameLabel = new JLabel("Username or Email");
        usernameLabel.setBounds(600, 212, 150, 30);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        usernameLabel.setForeground(Color.LIGHT_GRAY);
        add(usernameLabel);

        // username textfield
        username = new JTextField();
        username.setEditable(false);
        username.setBackground(Color.WHITE);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Tahoma", Font.PLAIN, 20));
        username.setBounds(595, 240, 300, 30);
        add(username);

        // password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(600, 282, 150, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        add(passwordLabel);

        // password textfield
        password = new JPasswordField();
        password.setEchoChar('*');
        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.PLAIN, 20));
        password.setBounds(595, 310, 300, 30);
        add(password);

        // forgot password
        forgotPassword = new JLabel("Forgot Password ?");
        forgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
        forgotPassword.setForeground(Color.lightGray);
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPassword.setBounds(805, 342, 100, 30);
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add Forgot Frame
                System.out.println("forgot button clicked");
            }
        });
        add(forgotPassword);

        // login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginButton.setForeground(Color.GRAY);
        loginButton.setBackground(Color.WHITE);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBounds(675, 388, 135, 40);
        loginButton.addActionListener(e -> {
            // Login process
            System.out.println("login button clicked");
        });
        add(loginButton);

        // signup text
        signup = new JLabel("<html>New to Phone book? <b><u><font color='gray'>Create Account</font></u></b></html>");
        signup.setFont(new Font("Tahoma", Font.PLAIN, 12));
        signup.setForeground(Color.GRAY);
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signup.setBounds(635, 510, 240, 30);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("signup button clicked");
            }
        });
        add(signup);

    }
}
