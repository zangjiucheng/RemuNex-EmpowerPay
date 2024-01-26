package com.prog2.main;

/**
 * This is the main class of the program. It is used to test the program.
 * 
 * @author Jiucheng Zang
 * @version 1.2
 * @since 2023-04-13
 *
 */

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.prog2.main.GUI.*;
import com.prog2.main.Process.*;

public class Main {

	/**
	 * Write your test code below in the main.
	 *
	 */
	public static void main(String[] args) {

		/**
		 * Get the operating system name
		 */

		os = System.getProperty("os.name").toUpperCase();
		// System.out.println(os);

		/**
		 * Serialization Drive Test
		 */

		// fileWrite();

		/**
		 * Font Check Test
		 */

		// Utiles.ListFont();

		/*
		 * GUI Drive Test
		 */

		if (os.contains("WINDOWS") || os.contains("MAC")) {
			// LoginGUI.GUI(); // Username: jiucheng Password: 123
			mainGUI.GUI();
			// departmentGUI.GUI();
			// teacherEditGUI.GUI();
		} else {
			JOptionPane.showMessageDialog(null, "This program is only supported on Windows or Mac OS X.");
		}

	}

	public static String os;

	/**
	 * This method is used to test the file writing and reading.
	 */
	public static void fileWrite() {
		/*
		 * Person Drive Test
		 */

		Teacher teacher = new Teacher("Adinash", "1234567890",
				"29873628@edu.vaniercollege.qc.ca", 'M', "Math", 5, 'B',
				"Mathematics");
		Teacher teacher2 = new Teacher("Brian", "324234235", "1236782164@edu.vaniercollege.qc.ca", 'M', "Math", 5, 'B',
				"Mathematics");
		Teacher teacher3 = new Teacher("Cindy", "324234235", "7f92y339@gmail.com", 'F', "English", 5, 'B',
				"English");
		// System.out.println(teacher);
		PartTimeTeacher partTimeTeacher = new PartTimeTeacher(teacher, 20);
		// System.out.println(partTimeTeacher);
		Staff staff = new Staff("Adinash", "1234567890",
				"1r928149812@helloworld.com", 'M', 14, "IT",
				"Mathematics");

		Staff staff2 = new Staff("Brian", "324234235", "ciuqbiwh@gmail.com", 'M', 5, "IT",
				"English");
		Staff staff3 = new Staff("Brian", "324234235", "ciuqbiwh@gmail.com", 'M', 5, "Apple",
				"Mathematics");
		// System.out.println(staff);
		Dean dean = new Dean(teacher);
		Dean dean2 = new Dean(teacher3);
		// System.out.println(teacher.getId());
		// System.out.println(partTimeTeacher.getId());
		// System.out.println(staff.getId());

		/*
		 * Department Drive Test
		 */

		ArrayList<Staff> staffList = new ArrayList<Staff>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		Department department = new Department("Mathematics", staffList,
				teacherList);
		department.addStaff(staff);
		department.addStaff(staff3);
		department.addTeacher(teacher);
		department.addTeacher(teacher2);
		department.addTeacher(partTimeTeacher);
		department.setDean(dean);
		staffList = new ArrayList<Staff>();
		teacherList = new ArrayList<Teacher>();
		Department department2 = new Department("English", staffList,
				teacherList);
		department2.addStaff(staff2);
		department2.addTeacher(teacher3);
		department2.setDean(dean2);
		// System.out.println(department);

		/*
		 * Serialization Drive Test
		 */

		// SerializationData.serializeData(department,
		// "./src/main/java/com/prog2/main/Data/Data1.ser");
		// Department department2 = (Department) SerializationData
		// .deserializeData("./src/main/java/com/prog2/main/Data/Data1.ser");
		// System.out.println(department2);

		/*
		 * Database Drive Test
		 */

		// Database database = new Database(
		// "/Users/jiucheng/Documents/Coding/H22ProgClass/data-structure-project-zangjiucheng/src/main/java/com/prog2/main/Data/database.db",
		// new ArrayList<Department>());
		// database.addDepartment(department);
		// database.addDepartment(department2);
		// // System.out.println(database);

		/*
		 * File Drive Test
		 */

		JFileChooser chooser = new JFileChooser(); // Chosse file directory to save the database
		// http://www.java2s.com/Tutorial/Java/0240__Swing/SelectadirectorywithaJFileChooser.htm
		chooser.setDialogTitle("Choose a directory to save the database");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			// String value_name = System.getenv("OS");
			// value_name = value_name.toUpperCase();
			if (Main.os.contains("WINDOWS")) {
				database = new Database(chooser.getSelectedFile() + "\\database.db");
				database.setFileDir(chooser.getSelectedFile() + "\\database.db");
			} else if (Main.os.contains("MAC")) {
				database = new Database(chooser.getSelectedFile() + "/database.db");
				database.setFileDir(chooser.getSelectedFile() + "/database.db");
			}
			database.addDepartment(department);
			database.addDepartment(department2);
			IOConnect.save(database);
		} else {
			System.out.println("No Selection");
		}

		// IOConnect.save(database);
		// Database fileData = IOConnect.connect(
		// "/Users/jiucheng/Documents/Coding/H22ProgClass/data-structure-project-zangjiucheng/src/main/java/com/prog2/main/Data/database.db");
		// System.out.println(fileData.getFileDir());
		// System.out.println(fileData.departmentList.toString());
		// IOConnect.delete(fileData);
		// IOConnect.delete("./src/main/java/com/prog2/main/Data/Database1.ser");
		System.out.println("Done");
		System.exit(0);
	}

	static Database database;

}