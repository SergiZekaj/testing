package Classes.integrationSergi;


import Classes.Appointment;
import Classes.AppointmentList;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentListIntegration {

    @BeforeEach
    void setUp() throws IOException {
        // Clear the appointment file before each test
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Files/AppointmentList.txt"))) {
            writer.write(""); // Clear content
        }
    }

    @Test
    void testAddAppointment() throws IOException {
        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");
        AppointmentList.addAppointment(app);

        // Verify in-memory list
        assertEquals(1, AppointmentList.appCount, "There should be one appointment in the list.");
        Appointment addedAppointment = AppointmentList.getAppointment(0);
        assertEquals("A001", addedAppointment.getAppId());
        assertEquals("John Doe", addedAppointment.getPatientName());
        assertEquals("Flu", addedAppointment.getDiagnosis());

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertEquals("A001", reader.readLine());  // Appointment ID
            assertEquals("John Doe", reader.readLine());  // Patient Name
            assertEquals("Flu", reader.readLine());  // Diagnosis
            assertEquals("Dr. Smith", reader.readLine());  // Doctor Name
            assertEquals("2025-01-23", reader.readLine());  // Appointment Date
            assertEquals("10:00 AM", reader.readLine());  // Appointment Time
        }
    }

    @Test
    void testDeleteAppointment() throws IOException {
        // Add an initial appointment
        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");
        AppointmentList.addAppointment(app);

        // Delete the appointment
        AppointmentList.deleteAppointment(app);

        // Verify in-memory list
        assertEquals(0, AppointmentList.appCount, "There should be no appointments left.");

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertNull(reader.readLine(), "File should be empty after deletion.");
        } catch (IOException e) {
            fail("Error while reading file: " + e.getMessage());
        }
    }

    @Test
    void testSearchAppointment() {
        // Add an initial appointment
        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00 AM");
        AppointmentList.addAppointment(app);

        // Search for the appointment
        int index = AppointmentList.searchAppointment("A001");
        assertEquals(0, index, "The appointment should be found at index 0.");
    }

    @Test
    void testAppointmentNotFound() {
        // Search for a non-existing appointment
        int index = AppointmentList.searchAppointment("A999");
        assertEquals(-1, index, "The appointment should not be found and return -1.");
    }
}
