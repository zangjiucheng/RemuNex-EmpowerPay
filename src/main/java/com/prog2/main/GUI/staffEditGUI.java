package com.prog2.main.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class is used to Edit Staff.
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-29
 * 
 */

public class staffEditGUI {
    public static void GUI() {
        mainFrame = new JFrame("Edit Staff");
        mainFrame.setSize(1730, 1080);
        mainFrame.setContentPane(new JLabel(
                Utiles.readImage("src/main/java/com/prog2/main/GUI/Resources/staff.jpg", 1730, 1080, 150)));
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(java.awt.Color.white);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainGUI.refresh();
            }
        });
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(420, 20, 1300, 1000);
        // infoPanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(infoPanel);
        mainFrame.add(infoPanel);

        JPanel editPanel = new JPanel();
        editPanel.setBounds(0, 0, 400, 1080);
        // editPanel.setBackground(java.awt.Color.white);
        // editPanel.setOpaque(true);
        editPanel.setBackground(new java.awt.Color(255, 255, 255, 180));
        // Utiles.transparentPanel(editPanel);
        mainFrame.add(editPanel);
        editPanel.setLayout(null);

        JPanel addPanel = new JPanel();
        addPanel.setBounds(20, 180, 360, 600);
        // addPanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(addPanel);
        editPanel.add(addPanel);

        JPanel addBottomPanel = new JPanel();
        addBottomPanel.setBounds(20, 800, 360, 40);
        // addBottomPanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(addBottomPanel);
        editPanel.add(addBottomPanel);

        JPanel deletePanel = new JPanel();
        deletePanel.setBounds(20, 20, 360, 150);
        // deletePanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(deletePanel);
        editPanel.add(deletePanel);

        staffEditElements.tableElement(infoPanel, mainGUI.dataBase,
                mainGUI.departmentIndex);

        staffEditElements.deleteStaffElement(deletePanel);

        staffEditElements.addStaffButtonElements(addBottomPanel); // Can not be swapped order with
                                                                  // addTeacherElement
        staffEditElements.addStaffElement(addPanel);

        staffEditElements.deleteStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getStaffList()
                        .size() == 0) {
                    JOptionPane.showMessageDialog(null, "No staff to delete", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    // throw new IllegalArgumentException("No staff to delete");
                }
                int index = Integer.parseInt(staffEditElements.deleteStaffIndexField.getText());
                try {
                    mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getStaffList().remove(index);
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Index out of bound", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    // throw new IllegalArgumentException("Index out of bound");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    // throw new IllegalArgumentException("Invalid input");
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Unknown error");
                }
                refresh();
            }
        });

        mainFrame.setVisible(true);

    }

    public static void refresh() {
        mainFrame.dispose();
        staffEditGUI.GUI();
        return;
    }

    protected static JFrame mainFrame;
}
