package com.management;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();

        JMenu student = new JMenu("Student");
        JMenu employee = new JMenu("Employee");

        JMenuItem addS = new JMenuItem("Add Student");
        JMenuItem viewS = new JMenuItem("View Students");

        JMenuItem addE = new JMenuItem("Add Employee");
        JMenuItem viewE = new JMenuItem("View Employees");

        addS.addActionListener(e -> new StudentForm());
        viewS.addActionListener(e -> new ViewStudents());

        addE.addActionListener(e -> new EmployeeForm());
        viewE.addActionListener(e -> new ViewEmployees());

        student.add(addS);
        student.add(viewS);

        employee.add(addE);
        employee.add(viewE);

        bar.add(student);
        bar.add(employee);

        setJMenuBar(bar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}