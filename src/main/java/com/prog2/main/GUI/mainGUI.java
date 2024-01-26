package com.prog2.main.GUI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import com.prog2.main.Process.IOConnect;
import com.prog2.main.Process.Department;
import com.prog2.main.Main;
import com.prog2.main.Process.Database;

/**
 * Main Panel GUI
 * 
 * @author Jiucheng Zang
 * @version 1.2.2
 * @since 2023-03-26
 *
 */

public class mainGUI {
    public static void GUI() {
        /**
         * Creating instance of JFrame
         */
        mainFrame = new JFrame("HR System");
        mainFrame.setSize(1730, 1080);
        mainFrame.setContentPane(new JLabel(
                Utiles.readImage("src/main/java/com/prog2/main/GUI/Resources/bk.jpg", 1730, 1080, 150)));
        // Set background
        // with image
        // https://stackoverflow.com/questions/18777893/jframe-background-image

        // JPanelWithBackground("src/main/java/com/prog2/main/GUI/Resources/bk.jpg"));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
                        "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    int save = JOptionPane.showConfirmDialog(null, "Do you want to save the data?",
                            "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
                    if (save == JOptionPane.YES_OPTION) {
                        IOConnect.save(dataBase);
                    }
                    System.exit(0);
                } else {
                    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        /**
         * Creating MenuBar and adding components
         */
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1920, 30);
        JMenu File = new JMenu("File");
        JMenu Departmrnt = new JMenu("Departmrnt");
        if (departmentList.size() != 0) {
            for (int i = 0; i < departmentList.size(); i++) {
                Departmrnt.add(departmentList.get(i));
            }
        }

        if (dataBase != null) {
            Departmrnt.setText("Departmrnt");
            JMenuItem addNew = new JMenuItem("Add New...");
            Departmrnt.add(addNew);
            addNew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("add new department");
                    departmentGUI.GUI();
                }
            });

            JMenuItem delete = new JMenuItem("Delete...");
            Departmrnt.add(delete);
            delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("delete department");
                    departmentGUI.deleteGUI(departmentIndex);
                }
            });
            if (dataBase.departmentList.size() == 0) {
                delete.setVisible(false);
            } else {
                delete.setVisible(true);
            }
        } else {
            Departmrnt.setText("Departmrnt (Not Connected to Database...) ");
        }

        JMenuItem AboutDeveloper = new JMenuItem("About Developer");
        menuBar.add(File);
        menuBar.add(Departmrnt);
        menuBar.add(AboutDeveloper);
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem newItem = new JMenuItem("New...");
        if (dataBase != null) { // temp solution fix later
            newItem.setVisible(false);
            loadItem.setVisible(false);
        }
        File.add(newItem);
        File.add(loadItem);
        File.add(saveItem);
        File.add(exitItem);
        mainFrame.add(menuBar);

        /**
         * Creating panel instance.
         */
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(20, 60, 900, 150);
        Utiles.transparentPanel(titlePanel);
        mainFrame.add(titlePanel);

        JPanel departmentJPanel = new JPanel();
        departmentJPanel.setBounds(20, 220, 800, 40);
        Utiles.transparentPanel(departmentJPanel);
        mainFrame.add(departmentJPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(1300, 70, 300, 170);
        Utiles.transparentPanel(buttonPanel);
        mainFrame.add(buttonPanel);

        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(300, 280, 1400, 750);
        Utiles.transparentPanel(tablePanel);
        mainFrame.add(tablePanel);

        JPanel deanPanel = new JPanel();
        deanPanel.setBounds(20, 300, 260, 400);
        deanPanel.setOpaque(true);
        deanPanel.setBackground(new java.awt.Color(255, 255, 255, 150));
        mainFrame.add(deanPanel);

        /**
         * add User Defined GUI elements
         */

        mainElements.titleElement(titlePanel);
        mainElements.tableElement(tablePanel, dataT, dataS, partTimeList);
        mainElements.deanElement(deanPanel, dataD);
        mainElements.departmentShow(departmentJPanel, departmentIndex);

        /**
         * add button
         */

        if ((departmentList.size() != 0) && (departmentIndex != -1)) {
            mainElements.buttonElement(buttonPanel);
            mainElements.editTeahcer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("editTeahcerButton");
                    mainFrame.dispose();
                    teacherEditGUI.GUI();
                }
            });
            mainElements.editStaff.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("editStaffButton");
                    mainFrame.dispose();
                    staffEditGUI.GUI();
                }
            });
        } else {
            mainElements.buttonElementNoDepartment(buttonPanel);
        }

        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(); // Chosse file directory to save the database
                                                           // http://www.java2s.com/Tutorial/Java/0240__Swing/SelectadirectorywithaJFileChooser.htm
                chooser.setDialogTitle("Choose a directory to save the database");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                    JOptionPane.showMessageDialog(null, "Database saved to " + chooser.getSelectedFile());
                    // String value_name = System.getenv("OS");
                    // value_name = value_name.toUpperCase();
                    if (Main.os.contains("WINDOWS")) {
                        dataBase = new Database(chooser.getSelectedFile() + "\\database.db");
                        dataBase.setFileDir(chooser.getSelectedFile() + "\\database.db");
                    } else if (Main.os.contains("MAC")) {
                        dataBase = new Database(chooser.getSelectedFile() + "/database.db");
                        dataBase.setFileDir(chooser.getSelectedFile() + "/database.db");
                    }
                    IOConnect.save(dataBase);
                    departmentIndex = -1;
                    refresh();
                } else {
                    System.out.println("No Selection");
                }

            }
        });

        loadItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int respones = fileChooser.showOpenDialog(mainFrame);
                if (respones == JFileChooser.APPROVE_OPTION) {
                    String fileDir = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Selected file: " + fileDir);
                    dataBase = IOConnect.connect(fileDir);
                    // System.out.println(fileDir);
                    // System.out.println(dataBase.getFileDir());
                    if (!fileDir.contains(dataBase.getFileDir())) {
                        JOptionPane.showMessageDialog(null,
                                "Database file is moved to another directory! It should be in "
                                        + dataBase.getFileDir() + "");
                        return;
                    }
                    // System.out.println(dataBase);
                    departmentIndex = 0;
                    refresh();
                }
            }
        });
        AboutDeveloper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWebpage(URI.create("https://github.com/zangjiucheng"));
            }
        });
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dataBase == null) {
                    JOptionPane.showMessageDialog(null, "No database to save");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Save file: " + dataBase.getFileDir());
                System.out.println("Save file: " + dataBase.getFileDir());
                IOConnect.save(dataBase);
            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
                        "Exit Program Message Box", JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    int save = JOptionPane.showConfirmDialog(null, "Do you want to save the data?",
                            "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
                    if (save == JOptionPane.YES_OPTION) {
                        IOConnect.save(dataBase);
                    }
                    System.exit(0);
                } else {
                    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        for (int i = 0; i < departmentList.size(); i++) {
            departmentList.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String choosen = e.getActionCommand();
                    for (int i = 0; i < departmentList.size(); i++) {
                        if (choosen.equals(departmentList.get(i).getText())) {
                            departmentIndex = i;
                            break;
                        }
                    }
                    // System.out.println("Department " + choosen + " is selected");
                    refresh();
                    return;
                }
            });
        }

        /**
         * Setting the frame visibility to true
         */

        mainFrame.setVisible(true); // Something wrong with this line when start the new File (Temporary fixed)
    }

    private static JFrame mainFrame;
    protected static Database dataBase;
    static final private String[] dataDDefault = { "<html>Name:<br/></html>", "<html>ID:<br/></html>",
            "<html>Phone:<br/></html>", "<html>Email:<br/></html>", "<html>Gender:<br/></html>",
            "<html>Specialty:<br/></html>", "<html>Experience:<br/></html>",
            "<html>Degree:<br/></html>", "<html>Salary:<br/></html>" };
    static protected String[] dataD = dataDDefault;
    static private String[][] dataT = {};
    static private String[][] dataS = {};
    static protected ArrayList<Integer> partTimeList;
    static protected ArrayList<JMenuItem> departmentList = new ArrayList<JMenuItem>();
    static protected int departmentIndex = -1;
    static protected int readOrderT = -1;
    static protected int readOrderS = -1;

    public static void refresh() {
        departmentList = new ArrayList<JMenuItem>();
        departmentList = RefreshData.refreshDepartment(dataBase);
        partTimeList = new ArrayList<Integer>();
        dataD = dataDDefault;
        Arrays.fill(dataT, null);
        Arrays.fill(dataS, null);
        if (dataBase.getDepartmentList().size() == 0) {
            // System.out.println("No department");
            mainFrame.dispose();
            GUI();
            return;
        }
        Department department = dataBase.getDepartmentList().get(departmentIndex);

        dataT = RefreshData.refreshTeacher(department, false, readOrderT); // false meas not include index
        dataS = RefreshData.refreshStaff(department, false, readOrderS); // readOrder = -1 means sort by add in time
        dataD = RefreshData.refreshDean(department, dataD);

        mainFrame.dispose();
        GUI();
        // System.out.println("Refreshed");
        return;
    }

    public static void refreshDean() {
        dataD = dataDDefault;
        dataD = RefreshData.refreshDean(dataBase.getDepartmentList().get(departmentIndex), dataD);
    }

    /**
     * @param uri
     * @return boolean
     */
    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
