package com.prog2.main.GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * This class is used to create elements for the GUI.
 * 
 * @author Jiucheng Zang
 * @version 1.0.1
 * @since 2023-03-27
 *
 */

public class mainElements {

    /**
     * @param panel
     */
    public static void titleElement(JPanel panel) {
        panel.setLayout(new GridLayout(1, 0));
        titlLabel = new JLabel();
        titlLabel.setText("Employee Development");
        titlLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        titlLabel.setBounds(50, 60, 1920, 100);
        panel.add(titlLabel);
    }

    /**
     * @param panel
     * @param data
     */
    public static void deanElement(JPanel panel, String[] data) {
        panel.setLayout(new GridLayout(10, 0));
        panel.setBorder(BorderFactory.createEtchedBorder());
        titlLabel = new JLabel();
        titlLabel.setText("Dean of the Faculty");
        titlLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        titlLabel.setBounds(10, 20, 270, 50);
        panel.add(titlLabel);

        JLabel nameLabel = new JLabel(data[0]);
        JLabel idLabel = new JLabel(data[1]);
        JLabel phoneLabel = new JLabel(data[2]);
        JLabel emailLabel = new JLabel(data[3]);
        JLabel genderLabel = new JLabel(data[4]);
        JLabel specialtyLabel = new JLabel(data[5]);
        JLabel experienceLabel = new JLabel(data[6]);
        JLabel degreeLabel = new JLabel(data[7]);
        JLabel salaryLabel = new JLabel(data[8]);
        panel.add(nameLabel);
        panel.add(idLabel);
        panel.add(phoneLabel);
        panel.add(emailLabel);
        panel.add(genderLabel);
        panel.add(specialtyLabel);
        panel.add(experienceLabel);
        panel.add(degreeLabel);
        panel.add(salaryLabel);
    }

    /**
     * @param panel
     * @param dataT
     * @param dataS
     * @param partTimeList
     */
    public static void tableElement(JPanel panel, String[][] dataT, String[][] dataS, ArrayList<Integer> partTimeList) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        final JPanel panelT = new JPanel();
        panelT.setLayout(new GridLayout(2, 0));
        panelT.setBackground(java.awt.Color.WHITE);
        final JLabel teacherLabel = new JLabel();
        teacherLabel.setText("Teacher List");
        teacherLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panelT.add(teacherLabel);
        JPanel orderJPanelT = new JPanel();
        orderJPanelT.setLayout(new GridLayout(1, 5));
        orderJPanelT.setBackground(java.awt.Color.WHITE);
        // orderJPanelT.setLayout(new GridLayout(1, 4));
        orderByAddInTimeT = new JButton("Order by Add in Time");
        orderByAddInTimeT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = -1;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByNameT = new JButton("Order by Name");
        orderByNameT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = 0;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByIDT = new JButton("Order by ID");
        orderByIDT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = 1;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderBySalaryT = new JButton("Order by Salary");
        orderBySalaryT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = 2;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderBySpecialtyT = new JButton("Order by Specialty");
        orderBySpecialtyT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = 3;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByExperienceT = new JButton("Order by Experience");
        orderByExperienceT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderT = 4;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderJPanelT.add(orderByAddInTimeT);
        orderJPanelT.add(orderByNameT);
        orderJPanelT.add(orderByIDT);
        orderJPanelT.add(orderBySpecialtyT);
        orderJPanelT.add(orderByExperienceT);
        orderJPanelT.add(orderBySalaryT);
        panelT.add(orderJPanelT);
        panel.add(panelT);

        String[] columnNamesT = { "Name", "ID", "Phone", "Email", "Gender", "Specialty", "Years of Experience",
                "Degree",
                "Salary", "hoursWorked" };

        teacherTable = new JTable(dataT, columnNamesT) { // Using for display light gray for part time teacher
                                                         // https://blog.csdn.net/w_1106/article/details/111303827
            @Override
            public java.awt.Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row,
                    int column) {
                int modelRow = convertRowIndexToModel(row);
                java.awt.Component comp = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(modelRow)) {
                    for (int i = 0; i < partTimeList.size(); i++) {
                        if (modelRow == partTimeList.get(i)) // judge if the row is part time teacher
                            comp.setBackground(java.awt.Color.lightGray);
                        else {
                            comp.setBackground(teacherTable.getBackground());
                        }
                    }
                }
                return comp;
            }

            // table not editable
            // https://blog.csdn.net/lianchao668/article/details/16858309
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        JScrollPane spT = new JScrollPane(teacherTable);
        panel.add(spT);

        final JPanel panelS = new JPanel();
        panelS.setLayout(new GridLayout(2, 0));
        panelS.setBackground(java.awt.Color.WHITE);
        final JLabel staffLabel = new JLabel();
        staffLabel.setText("Staff List");
        staffLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panelS.add(staffLabel);
        JPanel orderJPanelS = new JPanel();
        orderJPanelS.setLayout(new GridLayout(1, 5));
        orderJPanelS.setBackground(java.awt.Color.WHITE);
        // orderJPanelT.setLayout(new GridLayout(1, 4));
        orderByAddInTimeS = new JButton("Order by Add in Time");
        orderByAddInTimeS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = -1;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByNameS = new JButton("Order by Name");
        orderByNameS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = 0;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByIDS = new JButton("Order by ID");
        orderByIDS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = 1;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderBySalaryS = new JButton("Order by Salary");
        orderBySalaryS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = 2;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByDutyS = new JButton("Order by Duty");
        orderByDutyS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = 3;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderByWorkLoadS = new JButton("Order by Work Load Hours");
        orderByWorkLoadS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.readOrderS = 4;
                if (mainGUI.dataBase != null)
                    mainGUI.refresh();
            }
        });
        orderJPanelS.add(orderByAddInTimeS);
        orderJPanelS.add(orderByNameS);
        orderJPanelS.add(orderByIDS);
        orderJPanelS.add(orderByDutyS);
        orderJPanelS.add(orderByWorkLoadS);
        orderJPanelS.add(orderBySalaryS);
        panelS.add(orderJPanelS);
        panel.add(panelS);

        String[] columnNameS = { "Name", "ID", "Phone", "Email", "Gender", "WorkLoad", "Duty", "Salary" };
        staffTable = new JTable(dataS, columnNameS) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane spS = new JScrollPane(staffTable);
        panel.add(spS);

    }

    protected static JTable teacherTable;
    protected static JTable staffTable;
    protected static JButton buttonMain;
    protected static JLabel titlLabel;
    protected static JButton orderByAddInTimeT;
    protected static JButton orderByNameT;
    protected static JButton orderByIDT;
    protected static JButton orderBySalaryT;
    protected static JButton orderBySpecialtyT;
    protected static JButton orderByExperienceT;

    protected static JButton orderByAddInTimeS;
    protected static JButton orderByNameS;
    protected static JButton orderByIDS;
    protected static JButton orderBySalaryS;
    protected static JButton orderByDutyS;
    protected static JButton orderByWorkLoadS;

    /**
     * @param panel
     */
    public static void buttonElement(JPanel panel) {
        panel.setLayout(new GridLayout(2, 0));
        editTeahcer = new JButton("Edit Teacher");
        editStaff = new JButton("Edit Staff");
        panel.add(editTeahcer);
        panel.add(editStaff);
    }

    /**
     * @param buttonPanel
     */
    public static void buttonElementNoDepartment(JPanel buttonPanel) {
        buttonElement(buttonPanel);
        editTeahcer.setText("Edit Teacher (No Department Selected!)");
        editTeahcer.setEnabled(false);
        editStaff.setText("Edit Staff (No Department Selected!)");
        editStaff.setEnabled(false);
        orderByIDT.setEnabled(false);
        orderByAddInTimeT.setEnabled(false);
        orderByExperienceT.setEnabled(false);
        orderBySalaryT.setEnabled(false);
        orderBySpecialtyT.setEnabled(false);
        orderByNameT.setEnabled(false);

        orderByIDS.setEnabled(false);
        orderByAddInTimeS.setEnabled(false);
        orderByDutyS.setEnabled(false);
        orderBySalaryS.setEnabled(false);
        orderByWorkLoadS.setEnabled(false);
        orderByNameS.setEnabled(false);
    }

    protected static JButton editTeahcer;
    protected static JButton editStaff;

    /**
     * @param panel
     * @param index
     */
    public static void departmentShow(JPanel panel, int index) {
        panel.setLayout(new GridLayout(1, 0));
        JLabel departmentLabel = new JLabel();
        if (index != -1 && mainGUI.dataBase.getDepartmentList().size() != 0) {
            departmentLabel
                    .setText("Department Selection: " + mainGUI.dataBase.getDepartmentList().get(index).getName());
        } else {
            departmentLabel.setText("Department Selection:");
        }
        departmentLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(departmentLabel);
    }

}
