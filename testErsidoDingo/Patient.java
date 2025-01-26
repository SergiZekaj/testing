package Classes.testErsidoDingo;

import Classes.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testPatientConstructorAndGetters() {
        // Arrange
        String id = "P001";
        String name = "John Doe";
        String mobileNo = "1234567890";
        String gender = "Male";
        String age = "30";
        String address = "123 Main St, City";
        String appointedDoctor = "Dr. Smith";
        String room = "101";
        String diagnosis = "Fever";
        String deposit = "5000";

        // Act
        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Assert
        assertEquals(id, patient.getId(), "ID should match");
        assertEquals(name, patient.getName(), "Name should match");
        assertEquals(mobileNo, patient.getMobileNo(), "Mobile number should match");
        assertEquals(gender, patient.getGender(), "Gender should match");
        assertEquals(age, patient.getAge(), "Age should match");
        assertEquals(address, patient.getAddress(), "Address should match");
        assertEquals(appointedDoctor, patient.getAppointedDoctor(), "Appointed doctor should match");
        assertEquals(room, patient.getRoom(), "Room should match");
        assertEquals(diagnosis, patient.getDiagnosis(), "Diagnosis should match");
        assertEquals(deposit, patient.getDeposit(), "Deposit should match");
    }

    @Test
    void testSetters() {
        // Arrange
        Patient patient = new Patient("P001", "John Doe", "1234567890", "Male", "30", "123 Main St, City", "Dr. Smith", "101", "Fever", "5000");

        // Act
        patient.setAge("35");
        patient.setAddress("456 Elm St, Town");
        patient.setAppointedDoctor("Dr. Johnson");
        patient.setRoom("202");
        patient.setDiagnosis("Cold");
        patient.setDeposit("7000");

        // Assert
        assertEquals("35", patient.getAge(), "Age should be updated");
        assertEquals("456 Elm St, Town", patient.getAddress(), "Address should be updated");
        assertEquals("Dr. Johnson", patient.getAppointedDoctor(), "Appointed doctor should be updated");
        assertEquals("202", patient.getRoom(), "Room should be updated");
        assertEquals("Cold", patient.getDiagnosis(), "Diagnosis should be updated");
        assertEquals("7000", patient.getDeposit(), "Deposit should be updated");
    }

    @Test
    void testPatientConstructorWithNullValues() {
        // Arrange
        String id = null;
        String name = null;
        String mobileNo = null;
        String gender = null;
        String age = null;
        String address = null;
        String appointedDoctor = null;
        String room = null;
        String diagnosis = null;
        String deposit = null;

        // Act
        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Assert
        assertNull(patient.getId(), "ID should be null");
        assertNull(patient.getName(), "Name should be null");
        assertNull(patient.getMobileNo(), "Mobile number should be null");
        assertNull(patient.getGender(), "Gender should be null");
        assertNull(patient.getAge(), "Age should be null");
        assertNull(patient.getAddress(), "Address should be null");
        assertNull(patient.getAppointedDoctor(), "Appointed doctor should be null");
        assertNull(patient.getRoom(), "Room should be null");
        assertNull(patient.getDiagnosis(), "Diagnosis should be null");
        assertNull(patient.getDeposit(), "Deposit should be null");
    }

    @Test
    void testPatientConstructorWithEmptyValues() {
        // Arrange
        String id = "";
        String name = "";
        String mobileNo = "";
        String gender = "";
        String age = "";
        String address = "";
        String appointedDoctor = "";
        String room = "";
        String diagnosis = "";
        String deposit = "";

        // Act
        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Assert
        assertEquals("", patient.getId(), "ID should be empty");
        assertEquals("", patient.getName(), "Name should be empty");
        assertEquals("", patient.getMobileNo(), "Mobile number should be empty");
        assertEquals("", patient.getGender(), "Gender should be empty");
        assertEquals("", patient.getAge(), "Age should be empty");
        assertEquals("", patient.getAddress(), "Address should be empty");
        assertEquals("", patient.getAppointedDoctor(), "Appointed doctor should be empty");
        assertEquals("", patient.getRoom(), "Room should be empty");
        assertEquals("", patient.getDiagnosis(), "Diagnosis should be empty");
        assertEquals("", patient.getDeposit(), "Deposit should be empty");
    }
}