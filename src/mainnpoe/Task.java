/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainnpoe;


 // Represents a task.
 // Holds in about a task such as task name, task number, description, and developer details.
  
 
public class Task {
    private static int taskCounter = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;

    
     
    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;  // taskName The name of the task.
        this.taskNumber = taskCounter++; 
        this.taskDescription = taskDescription; // taskDescription The description of the task.
        this.developerDetails = developerFirstName + " " + developerLastName; // developerFirstName The first name of the developer assigned to the task.// developerLastName The last name of the developer assigned to the task.
        this.taskDuration = taskDuration; //  taskDuration The estimated duration of the task in hours.
    }

    
     
     
    public boolean checkTaskDescription() {   //Checks if the task description is not more than 50 characters.
        return taskDescription.length() <= 50;    // @return true if the task description is valid, false otherwise.
    }

    
     
    public String createTaskID() {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskId;
    }

    
      //Returns the full details of the task as a formatted string.
     // The details include task status, developer details, task number, task name, task description, task ID, and duration.
    // @return The formatted string of task details.
     
    public String printTaskDetails() {
        String details = "Task Status: " + getTaskStatus() + "\n"
                + "Developer Details: " + developerDetails + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Descrption: " + taskDescription + "\n"
                + "Task ID: " + createTaskID() + "\n"
                + "Duration: " + taskDuration + " hours";
        return details;
    }

    
    //  Returns the total combined hours of all entered tasks.
      // @return The total hours across all tasks.
     
    public static int returnTotalHours() {
        //calculates the amount of time for the tasks
        return 0;
    }

    
    private String getTaskStatus() {
        
        return "Pending";
    }
}
