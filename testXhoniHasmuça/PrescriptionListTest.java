package Classes.testXhoniHasmuça;

import Classes.Prescription;
import Classes.PrescriptionList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrescriptionListTest {
    private PrescriptionList prescriptionList;

    @BeforeEach
    public void setUp() {
        prescriptionList = new PrescriptionList();
    }

    @Test
    public void testAddPrescription() {
        Prescription prescription = new Prescription(
                "P123", "John Doe", "Flu", "Dr. Smith", "Paracetamol", "500mg", "Take one tablet every 8 hours"
        );
        prescriptionList.addPrescription(prescription);
        assertEquals(1, prescriptionList.pCount);
        assertEquals("John Doe", prescriptionList.getPrescription(0).getPatientName());
    }

    @Test
    public void testSearchPrescription() {
        Prescription prescription = new Prescription(
                "P123", "John Doe", "Flu", "Dr. Smith", "Paracetamol", "500mg", "Take one tablet every 8 hours"
        );
        prescriptionList.addPrescription(prescription);
        int index = prescriptionList.searchPrescription("P123");
        assertEquals(0, index);
    }

    @Test
    public void testSearchPrescriptionNotFound() {
        int index = prescriptionList.searchPrescription("NonexistentID");
        assertEquals(-1, index);
    }

    @Test
    public void testGetPrescription() {
        Prescription prescription = new Prescription(
                "P123", "John Doe", "Flu", "Dr. Smith", "Paracetamol", "500mg", "Take one tablet every 8 hours"
        );
        prescriptionList.addPrescription(prescription);
        Prescription retrievedPrescription = prescriptionList.getPrescription(0);
        assertNotNull(retrievedPrescription);
        assertEquals("John Doe", retrievedPrescription.getPatientName());
        assertEquals("Flu", retrievedPrescription.getDiagnosis());
    }

    @Test
    public void testFileNotFound() {
        // Rename or delete the "Files/prescriptions.txt" to test this manually.
        File file = new File("Files/prescriptions.txt");
        if (file.exists()) file.delete();  // Ensure the file does not exist.

        PrescriptionList testPrescriptionList = new PrescriptionList();
        assertEquals(0, testPrescriptionList.pCount);
    }

    @AfterEach
    public void tearDown() {
        // Clean up after tests if needed.
        prescriptionList=null;
    }
}