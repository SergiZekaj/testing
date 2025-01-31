package Classes.testSergi;

import Classes.PList;
import Classes.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PListTest{
    @BeforeEach
    void setUp() {
        PList pList = new PList();
        PList.pCount = 0;

        Patient p1 = new Patient("1", "Sergi Zekaj", "1234567890", "Male", "30", "123 Street", "Dr. Zekaj", "101", "Flu", "500");
        Patient p2 = new Patient("2", "Vesa Malaj", "0987654321", "Female", "25", "456 Avenue", "Dr. Hey", "102", "Cold", "300");
        pList.addPatient(p1);
        pList.addPatient(p2);
    }

    @Test
    void testSearchPatientFound() {
        int index = PList.searchPatient("1");
        assertEquals(0, index, "The patient with ID '1' should be found at index 0.");
    }

    @Test
    void testSearchPatientNotFound() {
        int index = PList.searchPatient("999");
        assertEquals(-1, index, "The patient with ID '999' should not be found.");
    }

    @Test
    void testGetPatient() {
        Patient patient = PList.getPatient(0);
        assertNotNull(patient, "The patient at index 0 should not be null.");
        assertEquals("Sergi Zekaj", patient.getName(), "The patient's name should be 'Sergi Zekaj'.");
    }

    @Test
    void testAddPatient() {
        Patient p1 = new Patient("1", "Sergi Zekaj", "1234567890", "Male", "30", "123 Street", "Dr. Zekaj", "101", "Flu", "500");

        PList.addPatient(p1);

        assertEquals(1, PList.pCount, "The patient count should be 1 after adding a patient.");

        Patient patient = PList.getPatient(0);
        assertNotNull(patient, "The patient at index 0 should not be null.");
        assertEquals("Sergi Zekaj", patient.getName(), "The patient's name should be 'Sergi Zekaj'.");
    }
}