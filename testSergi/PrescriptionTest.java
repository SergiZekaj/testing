package Classes.testSergi;

import Classes.Prescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrescriptionTest {
    private Prescription prescription;

        @BeforeEach
        void setUp() {
            // Initialize the Prescription object with test data
            prescription = new Prescription("1", "Sergi Zekaj", "Flu", "Dr. Zekaj", "Paracetamol", "500mg", "Take 1 tablet every 6 hours");
        }

        @Test
        void testGetPatientId() {
            assertEquals("1", prescription.getPatientId(), "The patient ID should be '1'.");
        }

        @Test
        void testGetPatientName() {
            assertEquals("Sergi Zekaj", prescription.getPatientName(), "The patient name should be 'Sergi Zekaj'.");
        }

        @Test
        void testGetDiagnosis() {
            assertEquals("Flu", prescription.getDiagnosis(), "The diagnosis should be 'Flu'.");
        }

        @Test
        void testGetDoctorName() {
            assertEquals("Dr. Zekaj", prescription.getDoctorName(), "The doctor's name should be 'Dr. Zekaj'.");
        }

        @Test
        void testGetMedicineName() {
            assertEquals("Paracetamol", prescription.getMedicineName(), "The medicine name should be 'Paracetamol'.");
        }

        @Test
        void testGetDosage() {
            assertEquals("500mg", prescription.getDosage(), "The dosage should be '500mg'.");
        }

        @Test
        void testGetUsageInstructions() {
            assertEquals("Take 1 tablet every 6 hours", prescription.getUsageInstructions(), "The usage instructions should be 'Take 1 tablet every 6 hours'.");
        }
}

