package it2d.bacacao.adoption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class config {
 

  //Connection Method to SQLITE 
    
 public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:BACACAOHIEDE.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    // Add Record Method
    public void addRecord(String sql, Object... values) {
        try (Connection conn = PetAdoption.connectDB(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]); // Simplified setting of values
            }
            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }

    // Add Pet Method
    public void addPet() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pet Name: ");
        String name = sc.next();
        System.out.print("Pet Species: ");
        String type = sc.next();
        System.out.print("Pet Breed: ");
        int age = sc.nextInt();
        System.out.print("Pet Status: ");
        String status = sc.next();

        String sql = "INSERT INTO Pets (name, species, breed, status) VALUES (?, ?, ?, ?)";
        addRecord(sql, name, type, age, status);
    }

    // Dynamic View Method
    public void viewRecords(String sqlQuery, String[] columnHeaders, String[] columnNames) {
        if (columnHeaders.length != columnNames.length) {
            System.out.println("Error: Mismatch between column headers and column names.");
            return;
        }

        try (Connection conn = PetAdoption.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
             ResultSet rs = pstmt.executeQuery()) {
            StringBuilder headerLine = new StringBuilder();
            headerLine.append("-----------------------------------------------------\n| ");
            for (String header : columnHeaders) {
                headerLine.append(String.format("%-20s | ", header));
            }
            headerLine.append("\n-----------------------------------------------------");

            System.out.println(headerLine.toString());

            while (rs.next()) {
                StringBuilder row = new StringBuilder("| ");
                for (String colName : columnNames) {
                    String value = rs.getString(colName);
                    row.append(String.format("%-20s | ", value != null ? value : ""));
                }
                System.out.println(row.toString());
            }
            System.out.println("-----------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error retrieving records: " + e.getMessage());
        }
    }

    void addAdoption(String sql, String fname, String lname, String email, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    }