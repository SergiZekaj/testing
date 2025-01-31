package Classes.testSergi;

import Classes.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentTest {

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        // Initialize the Appointment object with test data
        appointment = new Appointment("A123", "Sergi Zekaj", "Flu", "Dr. Zekaj", "2025-01-30", "10:00 AM");
    }

    @Test
    void testGetAppId() {
        assertEquals("A123", appointment.getAppId(), "The appointment ID should be 'A123'.");
    }

    @Test
    void testGetPatientName() {
        assertEquals("Sergi Zekaj", appointment.getPatientName(), "The patient name should be 'Sergi Zekaj'.");
    }

    @Test
    void testGetDiagnosis() {
        assertEquals("Flu", appointment.getDiagnosis(), "The diagnosis should be 'Flu'.");
    }

    @Test
    void testGetDoctorName() {
        assertEquals("Dr. Zekaj", appointment.getDoctorName(), "The doctor's name should be 'Dr. Zekaj'.");
    }

    @Test
    void testGetAppDate() {
        assertEquals("2025-01-30", appointment.getAppDate(), "The appointment date should be '2025-01-30'.");
    }

    @Test
    void testGetAppTime() {
        assertEquals("10:00 AM", appointment.getAppTime(), "The appointment time should be '10:00 AM'.");
    }
}