package Classes.systemSergi;

import Classes.Appointment;
import Classes.AppointmentList;
import Classes.Patient;
import Classes.PList;
import org.junit.jupiter.api.*;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class SystemTest {

    @BeforeEach
    void setUp() throws IOException {
        // Clear the files before each test to ensure isolated tests
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Files/PatientList.txt"))) {
            writer.write("");  // Clear Patient file
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Files/AppointmentList.txt"))) {
            writer.write("");  // Clear Appointment file
        }
    }

    @Test
    void testAddPatientAndScheduleAppointment() throws IOException {
        // Add a patient
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();  // Load existing patients if any
        pList.addPatient(p);

        // Verify patient is added to the list and file
        assertEquals(1, PList.pCount, "There should be one patient in the list.");

        try (BufferedReader reader = new BufferedReader(new FileReader("Files/PatientList.txt"))) {
            assertEquals("P001", reader.readLine());  // Patient ID
            assertEquals("John Doe", reader.readLine());  // Patient Name
        }

        // Now, add an appointment for this patient
        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00");
        AppointmentList appList = new AppointmentList();  // Load existing appointments if any
        appList.addAppointment(app);

        // Verify appointment is added to the list and file
        assertEquals(1, AppointmentList.appCount, "There should be one appointment in the list.");

        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertEquals("A001", reader.readLine());  // Appointment ID
            assertEquals("John Doe", reader.readLine());  // Patient Name
            assertEquals("Flu", reader.readLine());  // Diagnosis
            assertEquals("Dr. Smith", reader.readLine());  // Doctor
        }
    }

    @Test
    void testDeletePatientAndCancelAppointment() throws IOException {
        // Add a patient and appointment
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();
        pList.addPatient(p);

        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00");
        AppointmentList appList = new AppointmentList();
        appList.addAppointment(app);

        // Delete the appointment
        appList.deleteAppointment(app);

        // Verify appointment is removed from the list and file
        assertEquals(0, AppointmentList.appCount, "There should be no appointments in the list.");

        try (BufferedReader reader = new BufferedReader(new FileReader("Files/AppointmentList.txt"))) {
            assertNull(reader.readLine(), "The appointment file should be empty.");
        }

        // Delete the patient
        pList.deletePatient(p);

        // Verify patient is removed from the list and file
        assertEquals(0, PList.pCount, "There should be no patients in the list.");

        try (BufferedReader reader = new BufferedReader(new FileReader("Files/PatientList.txt"))) {
            assertNull(reader.readLine(), "The patient file should be empty.");
        }
    }

    @Test
    void testSearchPatientAndRetrieveAppointment() throws IOException {
        // Add a patient and appointment
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();
        pList.addPatient(p);

        Appointment app = new Appointment("A001", "John Doe", "Flu", "Dr. Smith", "2025-01-23", "10:00");
        AppointmentList appList = new AppointmentList();
        appList.addAppointment(app);

        // Search for the patient
        int patientIndex = pList.searchPatient("P001");
        assertEquals(0, patientIndex, "The patient should be found.");

        // Retrieve appointment for the patient
        Appointment retrievedApp = appList.getAppointment(0);
        assertNotNull(retrievedApp, "The appointment should be retrieved successfully.");
        assertEquals("A001", retrievedApp.getAppId(), "The appointment ID should match.");
    }
}
