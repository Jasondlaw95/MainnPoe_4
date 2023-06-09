/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainnpoe;

import javax.swing.JOptionPane;

public class MainnPoe {
    public static void main(String[] args) {
        Login login = new Login();

        int choice = 0;
        do {
            String menu = """
                Welcome to the Login System
                1. Register
                2. Login
                3. Exit
                Enter your choice: """;
            String choiceString = JOptionPane.showInputDialog(null, menu);

            try {
                choice = Integer.parseInt(choiceString);
                switch (choice) {
                    case 1 -> {
                        String username = JOptionPane.showInputDialog(null, "Enter username:");
                        String password = JOptionPane.showInputDialog(null, "Enter password:");
                        String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
                        String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
                        login = new Login(username, password, firstName, lastName);
                        JOptionPane.showMessageDialog(null, login.registerUser());
                    }
                    case 2 -> {
                        if (login == null) {
                            JOptionPane.showMessageDialog(null, "You must register first.");
                        } else {
                            String enteredUsername = JOptionPane.showInputDialog(null, "Enter username:");
                            String enteredPassword = JOptionPane.showInputDialog(null, "Enter password:");
                            JOptionPane.showMessageDialog(null, login.returnLoginStatus(enteredUsername, enteredPassword));
                        }
                    }
                    case 3 -> JOptionPane.showMessageDialog(null, "Goodbye!");
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid choice, please enter a number.");
            }
        } while (choice != 3);
    }
}
