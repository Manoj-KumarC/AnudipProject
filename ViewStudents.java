package com.management;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ViewStudents extends JFrame {

    public ViewStudents() {
        setTitle("Students");
        setSize(400,400);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area));

        try {
        	Connection con = DBConnection.getConnection();
        	Statement st = con.createStatement();   
        	ResultSet rs = st.executeQuery("SELECT * FROM students");

            while(rs.next()) {
                area.append(
                    rs.getInt(1)+" | "+
                    rs.getString(2)+" | "+
                    rs.getString(3)+" | "+
                    rs.getInt(4)+"\n"
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}