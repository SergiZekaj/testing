package Classes.integrationErsidoDingo;


import Classes.Prescription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrescriptionTest {

    @Test
    void testPrescriptionConstructorAndGetters() {
        // Arrange
        String patientId = "P001";
        String patientName = "John Doe";
        String diagnosis = "Fever";
        String doctorName = "Dr. Smith";
        String medicineName = "Paracetamol";
        String dosage = "500mg";
        String usageInstructions = "Take twice daily after meals";

        // Act
        Prescription prescription = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);

        // Assert
        assertEquals(patientId, prescription.getPatientId(), "Patient ID should match");
        assertEquals(patientName, prescription.getPatientName(), "Patient name should match");
        assertEquals(diagnosis, prescription.getDiagnosis(), "Diagnosis should match");
        assertEquals(doctorName, prescription.getDoctorName(), "Doctor name should match");
        assertEquals(medicineName, prescription.getMedicineName(), "Medicine name should match");
        assertEquals(dosage, prescription.getDosage(), "Dosage should match");
        assertEquals(usageInstructions, prescription.getUsageInstructions(), "Usage instructions should match");
    }

    @Test
    void testPrescriptionConstructorWithNullValues() {
        // Arrange
        String patientId = null;
        String patientName = null;
        String diagnosis = null;
        String doctorName = null;
        String medicineName = null;
        String dosage = null;
        String usageInstructions = null;

        // Act
        Prescription prescription = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);

        // Assert
        assertNull(prescription.getPatientId(), "Patient ID should be null");
        assertNull(prescription.getPatientName(), "Patient name should be null");
        assertNull(prescription.getDiagnosis(), "Diagnosis should be null");
        assertNull(prescription.getDoctorName(), "Doctor name should be null");
        assertNull(prescription.getMedicineName(), "Medicine name should be null");
        assertNull(prescription.getDosage(), "Dosage should be null");
        assertNull(prescription.getUsageInstructions(), "Usage instructions should be null");
    }

    @Test
    void testPrescriptionConstructorWithEmptyValues() {
        // Arrange
        String patientId = "";
        String patientName = "";
        String diagnosis = "";
        String doctorName = "";
        String medicineName = "";
        String dosage = "";
        String usageInstructions = "";

        // Act
        Prescription prescription = new Prescription(patientId, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);

        // Assert
        assertEquals("", prescription.getPatientId(), "Patient ID should be empty");
        assertEquals("", prescription.getPatientName(), "Patient name should be empty");
        assertEquals("", prescription.getDiagnosis(), "Diagnosis should be empty");
        assertEquals("", prescription.getDoctorName(), "Doctor name should be empty");
        assertEquals("", prescription.getMedicineName(), "Medicine name should be empty");
        assertEquals("", prescription.getDosage(), "Dosage should be empty");
        assertEquals("", prescription.getUsageInstructions(), "Usage instructions should be empty");
    }
}