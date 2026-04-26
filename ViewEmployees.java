package com.management;

import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame {

    public ViewEmployees() {
        setTitle("Employees");
        setSize(400,400);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area));

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while(rs.next()) {
                area.append(
                    rs.getInt(1)+" | "+
                    rs.getString(2)+" | "+
                    rs.getString(3)+" | "+
                    rs.getDouble(4)+"\n"
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}