package Classes.testSergi;

import Classes.Appointment;
import Classes.AppointmentList;
import org.junit.jupiter.api.*;
import java.io.*;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppointmentListTest {

    private AppointmentList appointmentList;

    // Helper method to create a sample appointment
    private Appointment createAppointment(String appId, String patientName, String diagnosis, String doctorName, String appDate, String appTime) {
        return new Appointment(appId, patientName, diagnosis, doctorName, appDate, appTime);
    }

    @BeforeEach
    void setup() {
        appointmentList = new AppointmentList(); // Initializes AppointmentList from file
        clearTestFile(); // Make sure the file is empty before each test
    }

    @AfterEach
    void tearDown() {
        clearTestFile(); // Clear the file after each test to keep tests independent
    }

    void clearTestFile() {
        try (FileWriter fw = new FileWriter("Files/AppointmentList.txt")) {
            fw.write(""); // Clear the file content
        } catch (IOException e) {
            System.out.println("Error clearing test file: " + e.getMessage());
        }
    }

    @Test
    void testAddAppointment() {
        Appointment app = createAppointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");

        appointmentList.addAppointment(app);

        // Verify in-memory appointment count
        assertEquals(1, AppointmentList.appCount, "The appointment count should be 1 after adding");

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertEquals("A001", reader.readLine()); // Appointment ID
            assertEquals("John Doe", reader.readLine()); // Patient name
            assertEquals("Flu", reader.readLine()); // Diagnosis
            assertEquals("Dr. Smith", reader.readLine()); // Doctor name
            assertEquals("2025-01-23", reader.readLine()); // Appointment date
            assertEquals("10:00 AM", reader.readLine()); // Appointment time
        } catch (IOException e) {
            fail("File reading failed: " + e.getMessage());
        }
    }

    @Test
    void testSearchAppointment() {
        Appointment app1 = createAppointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");
        Appointment app2 = createAppointment("A002", "Jane Doe", "Cold", "Dr. Green", "2025-01-24", "11:00 AM");
        appointmentList.addAppointment(app1);
        appointmentList.addAppointment(app2);

        int index = AppointmentList.searchAppointment("A002");
        assertEquals(1, index, "The appointment with ID A002 should be at index 1");

        Appointment foundApp = AppointmentList.getAppointment(index);
        assertEquals("Jane Doe", foundApp.getPatientName(), "The patient name should be Jane Doe");
    }

    @Test
    void testDeleteAppointment() {
        Appointment app1 = createAppointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");
        appointmentList.addAppointment(app1);
        assertEquals(1, AppointmentList.appCount, "The appointment count should be 1 before deletion");

        // Delete the appointment
        AppointmentList.deleteAppointment(app1);
        assertEquals(0, AppointmentList.appCount, "The appointment count should be 0 after deletion");

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertNull(reader.readLine(), "The file should be empty after deleting the appointment");
        } catch (IOException e) {
            fail("File reading failed: " + e.getMessage());
        }
    }
}