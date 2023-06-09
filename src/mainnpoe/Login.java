/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainnpoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Login {
    private String username;
    private String password;
    private String firstName;
    private final String lastName;

    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Login() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean checkUserName() {
        Pattern pattern = Pattern.compile("^\\w{1,5}_\\w*$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not formatted correctly. Please make sure it contains an underscore and is not longer than 5 characters.";
        } else if (checkPasswordComplexity()) {
            return "Welcome " + firstName + ", " + lastName + "! Registration completed.";
        } else {
            return "Password does not meet the complexity requirements. Please make sure it is not longer than 8 characters in length.";
        }
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Successful login.";
        } else {
            return "Failed login.";
        }
    }

    public static void main(String[] args) {
        Login login = null;
        boolean isLoggedIn = false; // Login status review
        TaskManager taskManager = null;

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        while (true) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "What would you like to do?\n" +
                            "Enter \"r\" to register, \"l\" to login, or \"q\" to quit."
            );

            if (input == null || input.equals("q")) {
                break;
            }

            switch (input) {
                case "r" -> {
                    String username = JOptionPane.showInputDialog(null, "Enter username:");
                    String password = JOptionPane.showInputDialog(null, "Enter password:");
                    String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
                    String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
                    login = new Login(username, password, firstName, lastName);
                    JOptionPane.showMessageDialog(null, login.registerUser());
                }
                case "l" -> {
                    if (login == null) {
                        JOptionPane.showMessageDialog(null, "You must register first.");
                    } else {
                        String enteredUsername = JOptionPane.showInputDialog(null, "Enter username:");
                        String enteredPassword = JOptionPane.showInputDialog(null, "Enter password:");
                        if (login.loginUser(enteredUsername, enteredPassword)) {
                            isLoggedIn = true; // Set login status true
                            taskManager = new TaskManager(); // Create new task manager
                            JOptionPane.showMessageDialog(null, login.returnLoginStatus(enteredUsername, enteredPassword));
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password.");
                        }
                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid input.");
            }

            if (isLoggedIn) {
                int choice = 0;
                do {
                    String menu = """
                            Choose an option:
                            1) Add tasks
                            2) Show report
                            3) Quit
                            Enter your choice:
                            """;
                    String choiceString = JOptionPane.showInputDialog(null, menu);

                    try {
                        choice = Integer.parseInt(choiceString);
                        switch (choice) {
                            case 1 -> {
                                String taskCountString = JOptionPane.showInputDialog(null, "Please enter the number of tasks:");
                                int taskCount = Integer.parseInt(taskCountString);
                                for (int i = 0; i < taskCount; i++) {
                                    String taskName = JOptionPane.showInputDialog(null, "Task name:");
                                    String taskDescription = JOptionPane.showInputDialog(null, "Task description (max 50 characters):");
                                    String developerFirstName = JOptionPane.showInputDialog(null, "Enter developer's first name:");
                                    String developerLastName = JOptionPane.showInputDialog(null, "Enter developer's last name:");
                                    String taskDurationString = JOptionPane.showInputDialog(null, "Enter task duration in hours:");
                                    int taskDuration = Integer.parseInt(taskDurationString);

                                    Task task = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration);
                                    taskManager.addTask(task);

                                    JOptionPane.showMessageDialog(null, task.printTaskDetails());
                                }
                                JOptionPane.showMessageDialog(null, "All tasks have been entered.");
                            }
                            case 2 -> JOptionPane.showMessageDialog(null, "Coming Soon");
                            case 3 -> JOptionPane.showMessageDialog(null, "Goodbye!");
                            default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid choice, please enter a number.");
                    }
                } while (choice != 3);

                // Display total hours
                JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + taskManager.returnTotalHours());
            }
        }
    }

    private boolean checkPasswordComplexity() {
        return password.length() <= 8;
    }

    private static class TaskManager {
        public TaskManager() {
        }

        private void addTask(Task task) {
            // Add task to the task manager
        }

        private String returnTotalHours() {
            // Calculate and return the total hours across all tasks
            return "0"; // Placeholder value,
        }
    }
}


