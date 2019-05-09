package jvm;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test27 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");

    }
}
