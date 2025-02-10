/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents a raw material in stock.
class RawMaterial {
    private int id;
    private String name;
    private int quantity;

    public RawMaterial(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public int getQuantity() { 
        return quantity; 
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Quantity: " + quantity;
    }
}

// Manages the list of raw materials.
class StockManager {
    // List to store raw materials in memory.
    private static List<RawMaterial> rawMaterials = new ArrayList<>();
    private static int nextId = 1;  // Auto-incrementing ID for new materials.

    // Adds a new raw material to the list.
    public static void addRawMaterial(String name, int quantity) {
        RawMaterial material = new RawMaterial(nextId++, name, quantity);
        rawMaterials.add(material);
        System.out.println("Raw material added successfully.");
    }

    // Displays all raw materials.
    public static void viewStock() {
        if (rawMaterials.isEmpty()) {
            System.out.println("No raw materials in stock.");
            return;
        }
        System.out.println("----- Stock List -----");
        for (RawMaterial material : rawMaterials) {
            System.out.println(material);
        }
    }

    // Updates the quantity of a raw material identified by its ID.
    public static void updateStock(int id, int quantity) {
        for (RawMaterial material : rawMaterials) {
            if (material.getId() == id) {
                material.setQuantity(quantity);
                System.out.println("Stock updated successfully.");
                return;
            }
        }
        System.out.println("Raw material with ID " + id + " not found.");
    }

    // Deletes a raw material from the list based on its ID.
    public static void deleteRawMaterial(int id) {
        for (int i = 0; i < rawMaterials.size(); i++) {
            if (rawMaterials.get(i).getId() == id) {
                rawMaterials.remove(i);
                System.out.println("Raw material deleted successfully.");
                return;
            }
        }
        System.out.println("Raw material with ID " + id + " not found.");
    }
}

public class Pharmacy {
    // Hard-coded login credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Simple login form in the console.
    public static boolean login(Scanner scanner) {
        System.out.println("=== Welcome to the Pharmacy Management System ===");
        System.out.print("Username: ");
        String inputUsername = scanner.next();
        System.out.print("Password: ");
        String inputPassword = scanner.next();
        if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
            System.out.println("Login successful!\n");
            return true;
        } else {
            System.out.println("Invalid credentials. Exiting the system.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user login.
        if (!login(scanner)) {
            scanner.close();
            return;
        }
        
        // Main menu loop.
        while (true) {
            System.out.println("\n===== Pharmacy Management Menu =====");
            System.out.println("1. Add Raw Material");
            System.out.println("2. View Stock");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Raw Material");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate input is an integer.
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // clear the invalid input
                continue;
            }
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter raw material name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    StockManager.addRawMaterial(name, quantity);
                    break;
                case 2:
                    StockManager.viewStock();
                    break;
                case 3:
                    System.out.print("Enter the ID of the raw material to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    StockManager.updateStock(updateId, newQuantity);
                    break;
                case 4:
                    System.out.print("Enter the ID of the raw material to delete: ");
                    int deleteId = scanner.nextInt();
                    StockManager.deleteRawMaterial(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }
    }
}


/**
 *
 * @author LENOVO
 */

