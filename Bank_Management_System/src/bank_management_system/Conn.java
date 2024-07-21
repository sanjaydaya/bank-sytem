package bank_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // Establishing the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "#@DAya$&211119@#");
            s = c.createStatement();
            
            System.out.println("Connected to database successfully.");
            
        } catch (Exception e) {
            // Handling any exceptions
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}
