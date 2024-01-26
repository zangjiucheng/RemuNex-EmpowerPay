package com.prog2.main.GUI;

import com.prog2.main.Process.Department;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Department GUI
 * 
 * @author Jiucheng Zang
 * @version 1.2.1
 * @since 2023-03-26
 *
 */

public class departmentGUI {
    public static void GUI() {
        mainFrame = new JFrame("=== Department ===");
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false); // disable resizing https://blog.csdn.net/qq_51228515/article/details/121178457
        mainFrame.getContentPane().setBackground(java.awt.Color.white);

        JPanel dPanel = new JPanel();
        dPanel.setBounds(20, 20, 260, 140);
        dPanel.setBackground(java.awt.Color.white);
        mainFrame.add(dPanel);
        dPanel.setLayout(null);
        final JLabel label = new JLabel("New Department Name:");
        label.setFont(new java.awt.Font("Dialog", 1, 14));
        label.setBounds(13, 0, 200, 30);
        dPanel.add(label);
        JTextField textField = new JTextField();
        textField.setBounds(20, 60, 200, 30);
        dPanel.add(textField);
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(20, 100, 100, 30);
        dPanel.add(confirmButton);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(140, 100, 100, 30);
        dPanel.add(cancelButton);
        mainFrame.setVisible(true);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                for (int i = 0; i < mainGUI.dataBase.departmentList.size(); i++) {
                    if (mainGUI.dataBase.departmentList.get(i).getName().equals(inputText)) {
                        JOptionPane.showMessageDialog(null, "Department already exists");
                        // throw new IllegalArgumentException("Department already exists");
                    }
                }
                mainGUI.dataBase.departmentList.add(new Department(inputText));
                mainGUI.departmentIndex = mainGUI.dataBase.departmentList.size() - 1;
                mainFrame.dispose();
                mainGUI.refresh();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }

    /**
     * @param index
     */
    public static void deleteGUI(int index) {
        if (mainGUI.dataBase.departmentList.size() == 0) {
            mainFrame.dispose();
            JOptionPane.showMessageDialog(null, "No department to delete");
            // throw new IllegalArgumentException("No department to delete");
        }
        mainFrame = new JFrame("=== Department ===");
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false); // disable resizing https://blog.csdn.net/qq_51228515/article/details/121178457
        mainFrame.getContentPane().setBackground(java.awt.Color.white);

        JPanel dPanel = new JPanel();
        dPanel.setBounds(20, 20, 260, 140);
        dPanel.setBackground(java.awt.Color.white);
        mainFrame.add(dPanel);
        dPanel.setLayout(null);
        final JLabel label = new JLabel(
                "Confirm to delete " + mainGUI.dataBase.departmentList.get(index).getName() + "?");
        label.setFont(new java.awt.Font("Dialog", 1, 14));
        label.setBounds(20, 0, 240, 30);
        dPanel.add(label);
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(20, 100, 100, 30);
        dPanel.add(confirmButton);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(140, 100, 100, 30);
        dPanel.add(cancelButton);
        JLabel picLabel = new JLabel(Utiles.readImage(
                "src/main/java/com/prog2/main/GUI/Resources/Warning.png",
                50, 50, 255));
        picLabel.setBounds(110, 50, 50, 50);
        dPanel.add(picLabel);
        mainFrame.setVisible(true);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.dataBase.departmentList.remove(index);
                mainGUI.departmentIndex = 0;
                mainFrame.dispose();
                mainGUI.refresh();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }

    private static JFrame mainFrame;
    private static JButton confirmButton;
    private static JButton cancelButton;
}
