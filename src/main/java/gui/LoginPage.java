package gui;

import Config.Config;
import controller.LoginController;
import helper.Helper;
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
    private JButton showPasswordButton;


    public LoginPage() {
        // set frame settings
        super("Welcome!");
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }
    private void initComponents() {
        // welcome to image
        welcomeImage = new JLabel(Helper.loadImageIcon("src/main/images/tournament-login.png"));
        welcomeImage.setBounds(90,125, 350, 350);
        add(welcomeImage);

        // image message
        imageMessage = new JLabel("Arrange sport tournaments");
        imageMessage.setBounds(177,480, 200, 30);
        imageMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        imageMessage.setForeground(Color.GRAY);
        add(imageMessage);

        // app title
        appTitle = new JLabel("Tournament Scheduler");
        appTitle.setBounds(630, 65, 250, 30);
        appTitle.setFont(new Font("Tahoma", Font.ITALIC, 24));
        appTitle.setForeground(Color.darkGray);
        add(appTitle);

        // welcome message
        welcomeMessage = new JLabel("Welcome to Tournament Scheduler");
        welcomeMessage.setBounds(585, 110, 320, 90);
        welcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        welcomeMessage.setForeground(Color.GRAY);
        add(welcomeMessage);

        // username label
        usernameLabel = new JLabel("Username or Email");
        usernameLabel.setBounds(600, 212, 150, 30);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        usernameLabel.setForeground(Color.LIGHT_GRAY);
        add(usernameLabel);

        // username text field
        username = new JTextField();
        username.setBackground(Color.WHITE);
        username.setForeground(Color.DARK_GRAY);
        username.setFont(new Font("Tahoma", Font.PLAIN, 19));
        username.setBounds(595, 240, 300, 30);
        add(username);

        // password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(600, 282, 150, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        add(passwordLabel);

        // password text field
        password = new JPasswordField();
        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.PLAIN, 19));
        password.setBounds(595, 310, 275, 30);
        add(password);

        // show password button
        showPasswordButton = new JButton(Helper.loadImageIcon("src/main/images/visibility.png"));
        showPasswordButton.setBounds(869, 311, 28, 28);
        showPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showPasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                password.setEchoChar((char) 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                password.setEchoChar('\u2022');
            }
        });
        add(showPasswordButton);

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
            if(Helper.isFieldEmpty(username, password)){
                Helper.showMessage("fill");
            }else if(!Helper.isValidEmail(username)){
                Helper.showMessage("wrong email", "Please enter a valid email");
            }else {
                if(LoginController.login(username.getText(), new String(password.getPassword()))){

                    new TournamentPage();
                    this.dispose();
                }
            }
        });
        add(loginButton);

        // signup text
        signup = new JLabel("<html>New to Tournament Scheduler? <b><u><font color='gray'>Create Account</font></u></b></html>");
        signup.setFont(new Font("Tahoma", Font.PLAIN, 12));
        signup.setForeground(Color.GRAY);
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signup.setBounds(610, 510, 300, 30);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("signup button clicked");
                new SignupPage();
            }
        });
        add(signup);
    }
}
