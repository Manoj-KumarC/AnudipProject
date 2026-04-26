package com.management;

import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class StudentForm extends JFrame {

    JTextField name, course, age;

    public StudentForm() {
        setTitle("Add Student");
        setSize(300, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(20,20,100,30);
        add(l1);

        name = new JTextField();
        name.setBounds(120,20,150,30);
        add(name);

        JLabel l2 = new JLabel("Course");
        l2.setBounds(20,60,100,30);
        add(l2);

        course = new JTextField();
        course.setBounds(120,60,150,30);
        add(course);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(20,100,100,30);
        add(l3);

        age = new JTextField();
        age.setBounds(120,100,150,30);
        add(age);

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
                "INSERT INTO students(name,course,age) VALUES(?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, course.getText());
            ps.setInt(3, Integer.parseInt(age.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Saved!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}