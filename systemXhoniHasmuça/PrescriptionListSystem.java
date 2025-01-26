package Classes.systemXhoniHasmuça;


import Classes.Prescription;
import Classes.PrescriptionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrescriptionListSystemTest {

    private PrescriptionList prescriptionList;

    @BeforeEach
    void setUp() {
        // Clear the file before each test
        try {
            new FileWriter("Files/prescriptions.txt", false).close();
        } catch (Exception ex) {
            System.out.println("Error clearing file: " + ex.getMessage());
        }

        // Reinitialize the PrescriptionList
        prescriptionList = new PrescriptionList();
    }

    @Test
    void testAddPrescription() {
        // Arrange
        String patientId = "P003";
        String patientName = "Alice Smith";
        String diagnosis = "Headache";
        String doctorName = "Dr. Brown";
        String medicineName = "Aspirin";
        String dosage = "300mg";
        String usageInstructions = "Take once daily";

        Prescription p = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);

        // Act
        prescriptionList.addPrescription(p);

        // Assert
        assertEquals(1, prescriptionList.pCount, "Prescription count should be 1");
        assertEquals(patientId, prescriptionList.prescriptionList[0].getPatientId(), "Patient ID should match");
        assertEquals(patientName, prescriptionList.prescriptionList[0].getPatientName(), "Patient name should match");
        assertEquals(diagnosis, prescriptionList.prescriptionList[0].getDiagnosis(), "Diagnosis should match");
        assertEquals(doctorName, prescriptionList.prescriptionList[0].getDoctorName(), "Doctor name should match");
        assertEquals(medicineName, prescriptionList.prescriptionList[0].getMedicineName(), "Medicine name should match");
        assertEquals(dosage, prescriptionList.prescriptionList[0].getDosage(), "Dosage should match");
        assertEquals(usageInstructions, prescriptionList.prescriptionList[0].getUsageInstructions(), "Usage instructions should match");
    }

    @Test
    void testSearchPrescription() {
        // Arrange
        String patientId = "P004";
        String patientName = "Bob Johnson";
        String diagnosis = "Cough";
        String doctorName = "Dr. Green";
        String medicineName = "Cough Syrup";
        String dosage = "10ml";
        String usageInstructions = "Take three times daily";

        Prescription p = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);
        prescriptionList.addPrescription(p);

        // Act
        int index = prescriptionList.searchPrescription(patientId);

        // Assert
        assertEquals(0, index, "Index should be 0");
    }

    @Test
    void testGetPrescription() {
        // Arrange
        String patientId = "P005";
        String patientName = "Charlie Brown";
        String diagnosis = "Allergy";
        String doctorName = "Dr. White";
        String medicineName = "Antihistamine";
        String dosage = "1 tablet";
        String usageInstructions = "Take once daily";

        Prescription p = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);
        prescriptionList.addPrescription(p);

        // Act
        Prescription retrievedPrescription = prescriptionList.getPrescription(0);

        // Assert
        assertEquals(patientId, retrievedPrescription.getPatientId(), "Patient ID should match");
        assertEquals(patientName, retrievedPrescription.getPatientName(), "Patient name should match");
        assertEquals(diagnosis, retrievedPrescription.getDiagnosis(), "Diagnosis should match");
        assertEquals(doctorName, retrievedPrescription.getDoctorName(), "Doctor name should match");
        assertEquals(medicineName, retrievedPrescription.getMedicineName(), "Medicine name should match");
        assertEquals(dosage, retrievedPrescription.getDosage(), "Dosage should match");
        assertEquals(usageInstructions, retrievedPrescription.getUsageInstructions(), "Usage instructions should match");
    }

}