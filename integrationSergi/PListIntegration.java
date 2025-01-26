package Classes.integrationSergi;

import Classes.Patient;
import Classes.PList;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class PListIntegration {

    @BeforeEach
    void setUp() throws IOException {
        // Clear the patient file before each test
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Files/PatientList.txt"))) {
            writer.write(""); // Clear content
        }
    }

    @Test
    void testAddPatient() throws IOException {
        // Create a new patient
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();  // This will load existing patients if any

        // Add the patient
        pList.addPatient(p);

        // Verify in-memory list
        assertEquals(1, PList.pCount, "There should be one patient in the list.");
        Patient addedPatient = pList.patientList[0];
        assertEquals("P001", addedPatient.getId());
        assertEquals("John Doe", addedPatient.getName());
        assertEquals("Flu", addedPatient.getDiagnosis());

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/PatientList.txt"))) {
            assertEquals("P001", reader.readLine());  // Patient ID
            assertEquals("John Doe", reader.readLine());  // Patient Name
            assertEquals("1234567890", reader.readLine());  // Mobile
            assertEquals("Male", reader.readLine());  // Gender
            assertEquals("30", reader.readLine());  // Age
            assertEquals("123 Main St", reader.readLine());  // Address
            assertEquals("Dr. Smith", reader.readLine());  // Appointed Doctor
            assertEquals("Room 101", reader.readLine());  // Room
            assertEquals("Flu", reader.readLine());  // Diagnosis
            assertEquals("5000", reader.readLine());  // Deposit
        }
    }

    @Test
    void testDeletePatient() throws IOException {
        // Create and add a patient
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();  // This will load existing patients if any
        pList.addPatient(p);

        // Delete the patient
        pList.deletePatient(p);

        // Verify in-memory list
        assertEquals(0, PList.pCount, "There should be no patients left.");

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/PatientList.txt"))) {
            assertNull(reader.readLine(), "File should be empty after deletion.");
        } catch (IOException e) {
            fail("Error while reading file: " + e.getMessage());
        }
    }

    @Test
    void testSearchPatient() {
        // Create and add a patient
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();  // This will load existing patients if any
        pList.addPatient(p);

        // Search for the patient
        int index = pList.searchPatient("P001");
        assertEquals(0, index, "The patient should be found at index 0.");
    }

    @Test
    void testPatientNotFound() {
        // Create and add a patient
        Patient p = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St", "Dr. Smith", "Room 101", "Flu", "5000");
        PList pList = new PList();  // This will load existing patients if any
        pList.addPatient(p);

        // Search for a non-existing patient
        int index = pList.searchPatient("P999");
        assertEquals(-1, index, "The patient should not be found and return -1.");
    }
}
