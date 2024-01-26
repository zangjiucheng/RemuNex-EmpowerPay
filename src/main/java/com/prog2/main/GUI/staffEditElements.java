package com.prog2.main.GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.prog2.main.Process.Database;
import com.prog2.main.Process.Staff;

/**
 * This class is used to Edit Staff Elements.
 * 
 * @author Jiucheng Zang
 * @version 1.2
 * @since 2023-03-29
 * 
 */

public class staffEditElements {

    /**
     * @param panel
     * @param database
     * @param index
     */
    public static void tableElement(JPanel panel, Database database, int index) {
        staffList = database.getDepartmentList().get(index).getStaffList();
        dataS = RefreshData.refreshStaff(database.getDepartmentList().get(index), true, mainGUI.readOrderS);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        final JLabel teacherLabel = new JLabel();
        teacherLabel.setText("Staff Teams");
        teacherLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(teacherLabel);

        String[] columnNamesS = { "Index", "Name", "ID", "Phone", "Email", "Gender", "WorkLoad", "Duty", "Salary" };

        staffTable = new JTable(dataS, columnNamesS) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane spT = new JScrollPane(staffTable);
        panel.add(spT);

    }

    protected static String[][] dataS;
    protected static JTable staffTable;
    protected static ArrayList<Staff> staffList;

    /**
     * @param panel
     */
    public static void deleteStaffElement(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel deleteStaffLabel = new JLabel();
        deleteStaffLabel.setText("Delete Staff");
        deleteStaffLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(deleteStaffLabel);
        JLabel deleteStaffIndexLabel = new JLabel();
        deleteStaffIndexLabel.setText("Index: ");
        deleteStaffIndexLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(deleteStaffIndexLabel);

        deleteStaffIndexField = new JTextField();
        deleteStaffIndexField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(deleteStaffIndexField);
        deleteStaffButton = new JButton();
        deleteStaffButton.setText("Delete");
        deleteStaffButton.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(deleteStaffButton);
    }

    protected static JButton deleteStaffButton;
    protected static JTextField deleteStaffIndexField;

    /**
     * @param panel
     */
    public static void addStaffElement(JPanel panel) {
        panel.setLayout(new GridLayout(13, 1));
        JLabel addStaffLabel = new JLabel();
        addStaffLabel.setText("Add Staff");
        addStaffLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(addStaffLabel);
        // UIManager.put("Label.font", new Font("Serif", Font.PLAIN, 26));
        JLabel addStaffNameLabel = new JLabel();
        addStaffNameLabel.setText("Name: ");
        panel.add(addStaffNameLabel);
        addStaffNameField = new JTextField();
        panel.add(addStaffNameField);
        JLabel addStaffPhoneLabel = new JLabel();
        addStaffPhoneLabel.setText("Phone: ");
        panel.add(addStaffPhoneLabel);
        addStaffPhoneField = new JTextField();
        panel.add(addStaffPhoneField);
        JLabel addStaffEmailLabel = new JLabel();
        addStaffEmailLabel.setText("Email: ");
        panel.add(addStaffEmailLabel);
        addStaffEmailField = new JTextField();
        panel.add(addStaffEmailField);
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 3));
        JRadioButton maleBox = new JRadioButton("Male");
        JRadioButton femaleBox = new JRadioButton("Female");
        JRadioButton otherBox = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBox);
        genderGroup.add(femaleBox);
        genderGroup.add(otherBox);
        genderPanel.add(maleBox);
        genderPanel.add(femaleBox);
        genderPanel.add(otherBox);
        panel.add(genderPanel);
        JLabel addStaffDutyLabel = new JLabel();
        addStaffDutyLabel.setText("Duty: ");
        panel.add(addStaffDutyLabel);
        addStaffDutyField = new JTextField();
        panel.add(addStaffDutyField);
        JLabel addWorkHour = new JLabel("Work Hours: ");
        addWorkLoadField = new JTextField();
        panel.add(addWorkHour);
        panel.add(addWorkLoadField);

        clearStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStaffNameField.setText("");
                addStaffPhoneField.setText("");
                addStaffEmailField.setText("");
                addStaffDutyField.setText("");
                addWorkLoadField.setText("");
            }
        });

        addStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char gender = ' ';
                if (maleBox.isSelected()) {
                    gender = 'M';
                } else if (femaleBox.isSelected()) {
                    gender = 'F';
                } else if (otherBox.isSelected()) {
                    gender = 'N';
                }
                if (check()) {
                    return;
                }
                try {
                    staffList.add(new Staff(addStaffNameField.getText(),
                            addStaffPhoneField.getText(),
                            addStaffEmailField.getText(), gender,
                            Integer.parseInt(addWorkLoadField.getText()),
                            addStaffDutyField.getText(),
                            mainGUI.dataBase.getDepartmentList().get(mainGUI.departmentIndex).getName()));
                } catch (IllegalArgumentException argument) {
                    JOptionPane.showMessageDialog(null, "Workload must be a number betweem 0 and 40 !");
                    return;
                }

                addStaffNameField.setText("");
                addStaffPhoneField.setText("");
                addStaffEmailField.setText("");
                addStaffDutyField.setText("");
                addWorkLoadField.setText("");
                staffEditGUI.refresh();
            }
        });
    }

    private static JTextField addStaffNameField;
    private static JTextField addStaffPhoneField;
    private static JTextField addStaffEmailField;
    private static JTextField addStaffDutyField;
    private static ButtonGroup genderGroup;
    private static JTextField addWorkLoadField;

    /**
     * @return boolean
     */
    public static boolean check() {
        if (addStaffNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the name of the Staff!");
            return true;
        }
        String currentNumber = addStaffPhoneField.getText().replaceAll(
                "[^0-9]", "");
        if (currentNumber.length() != addStaffPhoneField.getText().length()) {
            JOptionPane.showMessageDialog(null, "Please enter the valid phone number of the Staff!");
            return true;
        }
        if (addStaffEmailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the email of the Staff!");
            return true;
        }
        if (!addStaffEmailField.getText().contains("@") || !addStaffEmailField.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email!");
            return true;
        }
        if (genderGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Please select the gender!");
            return true;
        }
        if (addStaffDutyField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the duty of the Staff!");
            return true;
        }
        if (addWorkLoadField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter work hour for the Staff!");
            return true;
        }
        try {
            Integer.parseInt(addWorkLoadField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid work hour!");
            return true;
        }
        return false;
    }

    /**
     * @param ButtonPanel
     */
    public static void addStaffButtonElements(JPanel ButtonPanel) {
        ButtonPanel.setLayout(new GridLayout(0, 2, 0, 0));
        addStaffButton = new JButton();
        addStaffButton.setText("Add...");
        addStaffButton.setFont(new Font("Arial", Font.PLAIN, 25));
        ButtonPanel.add(addStaffButton);

        clearStaffButton = new JButton();
        clearStaffButton.setText("Clear");
        clearStaffButton.setFont(new Font("Arial", Font.PLAIN, 25));
        ButtonPanel.add(clearStaffButton);
    }

    protected static JButton addStaffButton;
    private static JButton clearStaffButton;

}
