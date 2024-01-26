package com.prog2.main.GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.prog2.main.Process.Database;
import com.prog2.main.Process.PartTimeTeacher;
import com.prog2.main.Process.Teacher;

/**
 * This class is used to Edit Teacher Elements.
 * 
 * @author Jiucheng Zang
 * @version 1.2.1
 * @since 2023-03-29
 * 
 */

public class teacherEditElements {

    /**
     * @param panel
     * @param database
     * @param index
     */
    public static void tableElement(JPanel panel, Database database, int index) {
        teacherList = database.getDepartmentList().get(index).getTeacherList();
        dataT = RefreshData.refreshTeacher(database.getDepartmentList().get(index), true, mainGUI.readOrderT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        final JLabel teacherLabel = new JLabel();
        teacherLabel.setText("Teacher Teams");
        teacherLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(teacherLabel);

        String[] columnNamesT = { "Index", "Name", "ID", "Phone", "Email", "Gender", "Specialty", "Years of Experience",
                "Degree",
                "Salary", "hoursWorked" };

        teacherTable = new JTable(dataT, columnNamesT) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane spT = new JScrollPane(teacherTable);
        panel.add(spT);

    }

    protected static String[][] dataT;
    protected static JTable teacherTable;
    protected static ArrayList<Teacher> teacherList;

    /**
     * @param panel
     */
    public static void deleteTeacherElement(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel deleteTeacherLabel = new JLabel();
        deleteTeacherLabel.setText("Delete Teacher");
        deleteTeacherLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(deleteTeacherLabel);
        JLabel deleteTeacherIndexLabel = new JLabel();
        deleteTeacherIndexLabel.setText("Index: ");
        deleteTeacherIndexLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(deleteTeacherIndexLabel);

        deleteTeacherIndexField = new JTextField();
        deleteTeacherIndexField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(deleteTeacherIndexField);
        deleteTeacherButton = new JButton();
        deleteTeacherButton.setText("Delete");
        deleteTeacherButton.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(deleteTeacherButton);
    }

    protected static JButton deleteTeacherButton;
    protected static JTextField deleteTeacherIndexField;

    /**
     * @param panel
     */
    public static void setDeanElement(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel deleteTeacherLabel = new JLabel();
        deleteTeacherLabel.setText("Set Dean");
        deleteTeacherLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(deleteTeacherLabel);
        JLabel setDeanIndexLabel = new JLabel();
        setDeanIndexLabel.setText("Index: ");
        setDeanIndexLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(setDeanIndexLabel);

        setDeanIndexField = new JTextField();
        setDeanIndexField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(setDeanIndexField);
        setDeanButton = new JButton();
        setDeanButton.setText("Set");
        setDeanButton.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(setDeanButton);
    }

    protected static JButton setDeanButton;
    protected static JTextField setDeanIndexField;

    /**
     * @param panel
     */
    public static void addTeacherElement(JPanel panel) {
        panel.setLayout(new GridLayout(16, 1));
        JLabel addTeacherLabel = new JLabel();
        addTeacherLabel.setText("Add Teacher");
        addTeacherLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(addTeacherLabel);
        // UIManager.put("Label.font", new Font("Serif", Font.PLAIN, 26));
        JLabel addTeacherNameLabel = new JLabel();
        addTeacherNameLabel.setText("Name: ");
        panel.add(addTeacherNameLabel);
        addTeacherNameField = new JTextField();
        panel.add(addTeacherNameField);
        JLabel addTeacherPhoneLabel = new JLabel();
        addTeacherPhoneLabel.setText("Phone: ");
        panel.add(addTeacherPhoneLabel);
        addTeacherPhoneField = new JTextField();
        panel.add(addTeacherPhoneField);
        JLabel addTeacherEmailLabel = new JLabel();
        addTeacherEmailLabel.setText("Email: ");
        panel.add(addTeacherEmailLabel);
        addTeacherEmailField = new JTextField();
        panel.add(addTeacherEmailField);
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
        JLabel addTeacherSpecialtyLabel = new JLabel();
        addTeacherSpecialtyLabel.setText("Specialty: ");
        panel.add(addTeacherSpecialtyLabel);
        addTeacherSpecialtyField = new JTextField();
        panel.add(addTeacherSpecialtyField);
        JLabel addTeacherYearsOfExperienceLabel = new JLabel();
        addTeacherYearsOfExperienceLabel.setText("Years of Experience: ");
        panel.add(addTeacherYearsOfExperienceLabel);
        addTeacherYearsOfExperienceField = new JTextField();
        panel.add(addTeacherYearsOfExperienceField);
        JPanel degreePanel = new JPanel();
        degreePanel.setLayout(new GridLayout(1, 3));
        JRadioButton bachlorBox = new JRadioButton("Bachlor's");
        JRadioButton masterBox = new JRadioButton("Master's");
        JRadioButton doctorBox = new JRadioButton("Doctor's");
        degreeGroup = new ButtonGroup();
        degreeGroup.add(bachlorBox);
        degreeGroup.add(masterBox);
        degreeGroup.add(doctorBox);
        degreePanel.add(bachlorBox);
        degreePanel.add(masterBox);
        degreePanel.add(doctorBox);
        panel.add(degreePanel);
        addIfPartTimeTeacher = new JCheckBox("Part Time Teacher");
        panel.add(addIfPartTimeTeacher);
        JLabel addWorkHour = new JLabel("Work Hours: ");
        addWorkHourField = new JTextField();
        panel.add(addWorkHour);
        addWorkHour.setVisible(false);
        panel.add(addWorkHourField);
        addWorkHourField.setVisible(false);
        addIfPartTimeTeacher.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (addIfPartTimeTeacher.isSelected()) {
                    addWorkHour.setVisible(true);
                    addWorkHourField.setVisible(true);
                } else {
                    addWorkHour.setVisible(false);
                    addWorkHourField.setVisible(false);
                }
                teacherEditGUI.mainFrame.revalidate();
            }
        });

        clearTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTeacherNameField.setText("");
                addTeacherPhoneField.setText("");
                addTeacherEmailField.setText("");
                addTeacherSpecialtyField.setText("");
                addTeacherYearsOfExperienceField.setText("");
                addWorkHourField.setText("");
            }
        });

        addTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char degree = ' ';
                if (bachlorBox.isSelected()) {
                    degree = 'B';
                } else if (masterBox.isSelected()) {
                    degree = 'M';
                } else if (doctorBox.isSelected()) {
                    degree = 'D';
                }
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
                if (addIfPartTimeTeacher.isSelected()) {
                    teacherList.add(new PartTimeTeacher(new Teacher(addTeacherNameField.getText(),
                            addTeacherPhoneField.getText(),
                            addTeacherEmailField.getText(), gender,
                            addTeacherSpecialtyField.getText(),
                            Integer.parseInt(addTeacherYearsOfExperienceField.getText()),
                            degree,
                            mainGUI.dataBase.getDepartmentList().get(mainGUI.departmentIndex).getName()),
                            Integer.parseInt(addWorkHourField.getText())));
                } else {
                    teacherList.add(new Teacher(addTeacherNameField.getText(),
                            addTeacherPhoneField.getText(),
                            addTeacherEmailField.getText(), gender,
                            addTeacherSpecialtyField.getText(),
                            Integer.parseInt(addTeacherYearsOfExperienceField.getText()),
                            degree,
                            mainGUI.dataBase.getDepartmentList().get(mainGUI.departmentIndex).getName()));
                }
                addTeacherNameField.setText("");
                addTeacherPhoneField.setText("");
                addTeacherEmailField.setText("");
                addTeacherSpecialtyField.setText("");
                addTeacherYearsOfExperienceField.setText("");
                addWorkHourField.setText("");
                teacherEditGUI.refresh();
            }
        });
    }

    private static JTextField addTeacherNameField;
    private static JTextField addTeacherPhoneField;
    private static JTextField addTeacherEmailField;
    private static ButtonGroup degreeGroup;
    private static JTextField addTeacherSpecialtyField;
    private static JTextField addTeacherYearsOfExperienceField;
    private static ButtonGroup genderGroup;
    private static JTextField addWorkHourField;
    private static JCheckBox addIfPartTimeTeacher;

    /**
     * @return boolean
     */
    public static boolean check() {
        if (addTeacherNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the name of the teacher!");
            return true;
        }
        String currentNumber = addTeacherPhoneField.getText().replaceAll(
                "[^0-9]", "");
        if (currentNumber.length() != addTeacherPhoneField.getText().length()) {
            JOptionPane.showMessageDialog(null, "Please enter the valid phone number of the teacher!");
            return true;
        }
        if (addTeacherEmailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the email of the teacher!");
            return true;
        }
        if (!addTeacherEmailField.getText().contains("@") || !addTeacherEmailField.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email!");
            return true;
        }
        if (genderGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Please select the gender!");
            return true;
        }
        if (addTeacherSpecialtyField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the specialty of the teacher!");
            return true;
        }
        if (addTeacherYearsOfExperienceField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the years of experience of the teacher!");
            return true;
        }
        try {
            Integer.parseInt(addTeacherYearsOfExperienceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for years of experience!");
            return true;
        }
        if (degreeGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Please select the degree of the teacher!");
            return true;
        }
        if (addIfPartTimeTeacher.isSelected()) {
            if (addWorkHourField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the work hours of the teacher!");
                return true;
            }
        }
        return false;
    }

    /**
     * @param ButtonPanel
     */
    public static void addTeacherButtonElements(JPanel ButtonPanel) {
        ButtonPanel.setLayout(new GridLayout(0, 2, 0, 0));
        addTeacherButton = new JButton();
        addTeacherButton.setText("Add...");
        addTeacherButton.setFont(new Font("Arial", Font.PLAIN, 25));
        ButtonPanel.add(addTeacherButton);

        clearTeacherButton = new JButton();
        clearTeacherButton.setText("Clear");
        clearTeacherButton.setFont(new Font("Arial", Font.PLAIN, 25));
        ButtonPanel.add(clearTeacherButton);
    }

    protected static JButton addTeacherButton;
    private static JButton clearTeacherButton;

}
