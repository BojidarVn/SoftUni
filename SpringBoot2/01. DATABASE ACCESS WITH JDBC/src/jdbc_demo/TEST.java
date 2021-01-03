package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username default (root): ");
        String user = sc.nextLine().trim();
        user = user.equals("") ? "root" : user;

        System.out.println("Enter password default (root): ");
        String password = sc.nextLine();
        password = password.equals("") ? "root" : "kit123k@t123";

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        //1. Load jdbc driver (optional)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Driver load successfully.");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        System.out.println("Connected successfully");

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");
        System.out.println("Enter minimal salary:" );
        String salaryStre = sc.nextLine().trim();

    }
}
