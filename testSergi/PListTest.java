package Classes.testSergi;

import Classes.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PListTest {
    private PList patientList;
    private final String testFilePath = "Files/PatientList.txt";

    @BeforeEach
    void setup() {
        // Reinitialize PList and clear the test file before each test
        patientList = new PList();
        clearTestFile();
    }

    @AfterEach
    void tearDown() {
        clearTestFile(); // Clear the file after each test
    }

    void clearTestFile() {
        try (FileWriter fw = new FileWriter(testFilePath)) {
            fw.write(""); // Clear the file content
        } catch (IOException e) {
            System.out.println("Error clearing test file: " + e.getMessage());
        }
    }

    @Test
    void testAddPatient() {
        Patient patient = new Patient("P001", "John Doe", "1234567890", "Male", "30",
                "123 Main St", "Dr. Smith", "101", "Flu", "500");
        patientList.addPatient(patient);

        // Verify in-memory data
        assertEquals(1, PList.pCount);
        assertEquals("P001", patientList.patientList[0].getId());

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath))) {
            assertEquals("P001", reader.readLine()); // First line in file
            assertEquals("John Doe", reader.readLine()); // Second line
        } catch (IOException e) {
            fail("File reading failed: " + e.getMessage());
        }
    }

    @Test
    void testSearchPatient() {
        Patient patient1 = new Patient("P001", "John Doe", "1234567890", "Male", "30",
                "123 Main St", "Dr. Smith", "101", "Flu", "500");
        Patient patient2 = new Patient("P002", "Jane Doe", "0987654321", "Female", "25",
                "456 Elm St", "Dr. Green", "102", "Cold", "300");
        patientList.addPatient(patient1);
        patientList.addPatient(patient2);

        // Search by ID
        int index = patientList.searchPatient("P002");
        assertEquals(1, index);
        assertEquals("Jane Doe", patientList.getPatient(index).getName());
    }

    @Test
    void testDeletePatient() {
        Patient patient1 = new Patient("P001", "John Doe", "1234567890", "Male", "30",
                "123 Main St", "Dr. Smith", "101", "Flu", "500");
        Patient patient2 = new Patient("P002", "Jane Doe", "0987654321", "Female", "25",
                "456 Elm St", "Dr. Green", "102", "Cold", "300");
        patientList.addPatient(patient1);
        patientList.addPatient(patient2);

        // Delete the first patient
        patientList.deletePatient(patient1);

        // Verify in-memory data
        assertEquals(1, PList.pCount);
        assertEquals("P002", patientList.patientList[0].getId());

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath))) {
            assertEquals("P002", reader.readLine()); // Remaining patient's ID
        } catch (IOException e) {
            fail("File reading failed: " + e.getMessage());
        }
    }
}
