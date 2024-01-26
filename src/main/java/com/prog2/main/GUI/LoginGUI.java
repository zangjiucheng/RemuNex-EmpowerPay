package com.prog2.main.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Login GUI
 * 
 * @author Jiucheng Zang
 * @version 1.3
 * @since 2023-03-27
 * @see com.prog2.main.GUI.ElementsGUI
 * 
 */

public class LoginGUI {

    public static void GUI() {

        /*
         * Creating instance of JFrame
         */

        frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Creating panel instance.
         */

        JPanel panel = new JPanel();
        frame.add(panel);

        /*
         * add User Defined GUI elements
         */

        loginElements.loginElement(panel);
        loginElements.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((loginElements.userText.getText().equals("jiucheng"))
                        && (new String(loginElements.passwordText.getPassword()).equals("123"))) {
                    frame.dispose();
                    mainGUI.GUI();
                } else {
                    System.out.println("Login Failed");
                    loginElements.errorLabel.setVisible(true);
                    loginElements.userText.setText("");
                    loginElements.passwordText.setText("");
                }
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // get screen size
                                                                     // https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    private static JFrame frame;
}
