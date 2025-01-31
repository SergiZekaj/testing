package Classes.testSergi;

import Classes.Appointment;
import Classes.AppointmentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppointmentListTest{
    @BeforeEach
    void setUp() {
        AppointmentList.appointmentList = new Appointment[100];
        AppointmentList.appCount = 0;
        
        
        Appointment app1 = new Appointment("1", "Sergi Zekaj", "Flu", "Dr. Zekaj", "2025-01-30", "10:00 AM");
        Appointment app2 = new Appointment("2", "Vesa Malaj", "Cold", "Dr. Hey", "2025-01-30", "11:00 AM");
        AppointmentList.addAppointment(app1);
        AppointmentList.addAppointment(app2);
    }

    @Test
    void testSearchAppointmentFound() {
        int index = AppointmentList.searchAppointment("1");
        assertEquals(0, index, "The appointment with appId '1' should be found at index 0.");
    }

    @Test
    void testSearchAppointmentNotFound() {
        int index = AppointmentList.searchAppointment("999");
        assertEquals(-1, index, "The appointment with appId '999' should not be found.");
    }

    @Test
    void testGetAppointment() {
        Appointment appointment = AppointmentList.getAppointment(0);
        assertNotNull(appointment, "The appointment at index 0 should not be null.");
        assertEquals("Sergi Zekaj", appointment.getPatientName(), "The patient name should be 'Sergi Zekaj'.");
    }
}