package Classes.integrationXhoniHasmuça;


import Classes.Prescription;
import Classes.PrescriptionList;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class PrescriptionListIntegration {

    private static final String TEST_FILE_PATH = "Files/prescriptions.txt";
    private PrescriptionList prescriptionList;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a clean test file before each test
        File file = new File(TEST_FILE_PATH);
        file.getParentFile().mkdirs(); // Ensure the directory exists
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Patient ID: P001\n");
            fw.write("Patient Name: John Doe\n");
            fw.write("Diagnosis: Flu\n");
            fw.write("Doctor's Name: Dr. Smith\n");
            fw.write("Medicine Name: Paracetamol\n");
            fw.write("Dosage: 500mg\n");
            fw.write("Usage Instructions: Take twice daily\n\n");
        }
        prescriptionList = new PrescriptionList();
    }

    @AfterEach
    public void tearDown() {
        // Clean up the test file after each test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testConstructor() {
        // Verify that the constructor correctly reads the file and populates the list
        assertEquals(1, PrescriptionList.pCount);
        Prescription p = prescriptionList.getPrescription(0);
        assertNotNull(p);
        assertEquals("P001", p.getPatientId());
        assertEquals("John Doe", p.getPatientName());
        assertEquals("Flu", p.getDiagnosis());
        assertEquals("Dr. Smith", p.getDoctorName());
        assertEquals("Paracetamol", p.getMedicineName());
        assertEquals("500mg", p.getDosage());
        assertEquals("Take twice daily", p.getUsageInstructions());
    }

    @Test
    public void testAddPrescription() throws IOException {
        // Add a new prescription
        Prescription newPrescription = new Prescription("P002", "Jane Doe", "Headache", "Dr. Brown", "Ibuprofen", "400mg", "Take once daily");
        prescriptionList.addPrescription(newPrescription);

        // Verify that the prescription was added to the list
        assertEquals(2, PrescriptionList.pCount);
        Prescription p = prescriptionList.getPrescription(1);
        assertNotNull(p);
        assertEquals("P002", p.getPatientId());
        assertEquals("Jane Doe", p.getPatientName());
        assertEquals("Headache", p.getDiagnosis());
        assertEquals("Dr. Brown", p.getDoctorName());
        assertEquals("Ibuprofen", p.getMedicineName());
        assertEquals("400mg", p.getDosage());
        assertEquals("Take once daily", p.getUsageInstructions());

        // Verify that the prescription was appended to the file
        try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            assertTrue(content.toString().contains("Patient ID: P002"));
            assertTrue(content.toString().contains("Patient Name: Jane Doe"));
            assertTrue(content.toString().contains("Diagnosis: Headache"));
            assertTrue(content.toString().contains("Doctor's Name: Dr. Brown"));
            assertTrue(content.toString().contains("Medicine Name: Ibuprofen"));
            assertTrue(content.toString().contains("Dosage: 400mg"));
            assertTrue(content.toString().contains("Usage Instructions: Take once daily"));
        }
    }

    @Test
    public void testSearchPrescription() {
        // Search for an existing prescription
        int index = prescriptionList.searchPrescription("P001");
        assertEquals(0, index);

        // Search for a non-existent prescription
        index = prescriptionList.searchPrescription("P999");
        assertEquals(-1, index);
    }

}