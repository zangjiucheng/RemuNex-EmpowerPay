package com.prog2.main.GUI;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class is used to create elements for the GUI.
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-27
 *
 */

public class loginElements {

    /**
     * @param panel
     */
    public static void loginElement(JPanel panel) {

        /**
         * Set the layout to null.
         */

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");

        /*
         * setBounds(x, y, width, height)
         * 
         * x and y are cordinates from the top left, and width and height determine the
         * size.
         */

        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        /*
         * Create text field where user is supposed to enter user name.
         */

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        /*
         * Password Label
         */

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        /**
         * Password Text Field where user is supposed to enter password.
         * Can't see what user is typing (Protected Privacy)
         */

        passwordText = new JPasswordField(20);
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        /**
         * Create login button
         */

        loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        errorLabel = new JLabel("Login Failed");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        errorLabel.setBounds(100, 80, 165, 25);
        errorLabel.setForeground(java.awt.Color.RED);
        errorLabel.setVisible(false);
        panel.add(errorLabel);
    }

    protected static JButton loginButton;
    protected static JTextField userText;
    protected static JPasswordField passwordText;
    protected static JLabel errorLabel;

}
