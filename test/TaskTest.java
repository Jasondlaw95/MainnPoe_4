/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jason
 */
import mainnpoe.Task;
import org.junit.Test;

public class TaskTest {
    @Test
    public void testCheckTaskDescription_ValidDescription_ReturnsTrue() {
        
        Task task = new Task("Test Task", "This is a valid task description.", "John", "Doe", 5);

        boolean result = task.checkTaskDescription();

        assertTrue(result);
    }

    private void assertTrue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(boolean result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

