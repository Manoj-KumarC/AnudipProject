package com.management;

import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class EmployeeForm extends JFrame {

    JTextField name, dept, salary;

    public EmployeeForm() {
        setTitle("Add Employee");
        setSize(300,250);
        setLayout(null);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(20,20,100,30);
        add(l1);

        name = new JTextField();
        name.setBounds(120,20,150,30);
        add(name);

        JLabel l2 = new JLabel("Department");
        l2.setBounds(20,60,100,30);
        add(l2);

        dept = new JTextField();
        dept.setBounds(120,60,150,30);
        add(dept);

        JLabel l3 = new JLabel("Salary");
        l3.setBounds(20,100,100,30);
        add(l3);

        salary = new JTextField();
        salary.setBounds(120,100,150,30);
        add(salary);

        JButton btn = new JButton("Save");
        btn.setBounds(80,150,120,30);
        add(btn);

        btn.addActionListener(e -> save());

        setVisible(true);
    }

    void save() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employees(name,department,salary) VALUES(?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, dept.getText());
            ps.setDouble(3, Double.parseDouble(salary.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Saved!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}