package com.prog2.main.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.prog2.main.Process.Dean;

/**
 * This class is used to Edit Teacher.
 * 
 * @author Jiucheng Zang
 * @version 1.0.1
 * @since 2023-03-29
 * 
 */

public class teacherEditGUI {
    public static void GUI() {
        mainFrame = new JFrame("Edit Teacher");
        mainFrame.setSize(1730, 1080);
        mainFrame.setContentPane(new JLabel(
                Utiles.readImage("src/main/java/com/prog2/main/GUI/Resources/Teacher-Resources.jpg", 1730, 1080, 150)));
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(java.awt.Color.white);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getDean() == null) {
                    JOptionPane.showMessageDialog(null, "Warning: No Dean Been Set");
                }
                mainGUI.refresh();
            }
        });
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(420, 20, 1300, 1000);
        // infoPanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(infoPanel);
        mainFrame.add(infoPanel);

        JPanel deanPanel = new JPanel();
        deanPanel.setBounds(20, 20, 360, 150);
        // deanPanel.setBackground(java.awt.Color.white);
        // deanPanel.setOpaque(true);
        deanPanel.setBackground(new java.awt.Color(255, 255, 255, 150));
        // Utiles.transparentPanel(deanPanel);
        infoPanel.add(deanPanel);

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
        deletePanel.setBounds(20, 850, 360, 150);
        // deletePanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(deletePanel);
        editPanel.add(deletePanel);

        JPanel setDeanPanel = new JPanel();
        setDeanPanel.setBounds(20, 20, 360, 150);
        // setDeanPanel.setBackground(java.awt.Color.white);
        Utiles.transparentPanel(setDeanPanel);
        editPanel.add(setDeanPanel);

        mainElements.deanElement(deanPanel, mainGUI.dataD);

        teacherEditElements.tableElement(infoPanel, mainGUI.dataBase,
                mainGUI.departmentIndex);
        teacherEditElements.deleteTeacherElement(deletePanel);
        teacherEditElements.addTeacherButtonElements(addBottomPanel); // Can not be swapped order with
                                                                      // addTeacherElement
        teacherEditElements.addTeacherElement(addPanel);
        teacherEditElements.setDeanElement(setDeanPanel);

        teacherEditElements.deleteTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getTeacherList()
                        .size() == 0) {
                    JOptionPane.showMessageDialog(null, "No teacher to delete!");
                    return;
                    // throw new IllegalArgumentException("No teacher to delete");
                }

                int index = Integer.parseInt(teacherEditElements.deleteTeacherIndexField.getText());
                if (mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getDean().getTeacher()
                        .getId() == mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getTeacherList()
                                .get(index)
                                .getId()) {
                    JOptionPane.showMessageDialog(null, "Dean can not be deleted!");
                    return;
                    // throw new IllegalArgumentException("Dean can not be deleted!");
                }
                try {
                    mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getTeacherList().remove(index);
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Index of Teacher out of bound!");
                    // throw new IllegalArgumentException("Index out of bound");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    // throw new IllegalArgumentException("Invalid input");
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Unknown error");
                }
                refresh();
            }
        });

        teacherEditElements.setDeanButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(teacherEditElements.setDeanIndexField.getText());
                try {
                    mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).setDean(
                            new Dean(mainGUI.dataBase.departmentList.get(mainGUI.departmentIndex).getTeacherList()
                                    .get(index)));
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Index of Teacher out of bound!");
                    // throw new IllegalArgumentException("Index out of bound");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    // throw new IllegalArgumentException("Invalid input");
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Unknown error");
                }
                mainGUI.refreshDean();
                refresh();
            }

        });

        mainFrame.setVisible(true);

    }

    public static void refresh() {
        mainFrame.dispose();
        teacherEditGUI.GUI();
        return;
    }

    protected static JFrame mainFrame;
}
