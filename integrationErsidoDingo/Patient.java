package Classes.integrationErsidoDingo;


import Classes.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientIntegrationTest {

    @Test
    void testPatientInheritsPersonFields() {
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
        assertEquals(id, patient.getId(), "ID should match (inherited from Person)");
        assertEquals(name, patient.getName(), "Name should match (inherited from Person)");
        assertEquals(mobileNo, patient.getMobileNo(), "Mobile number should match (inherited from Person)");
        assertEquals(gender, patient.getGender(), "Gender should match (inherited from Person)");
    }

    @Test
    void testPatientSpecificFields() {
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
        assertEquals(age, patient.getAge(), "Age should match");
        assertEquals(address, patient.getAddress(), "Address should match");
        assertEquals(appointedDoctor, patient.getAppointedDoctor(), "Appointed doctor should match");
        assertEquals(room, patient.getRoom(), "Room should match");
        assertEquals(diagnosis, patient.getDiagnosis(), "Diagnosis should match");
        assertEquals(deposit, patient.getDeposit(), "Deposit should match");
    }

    @Test
    void testPatientSetters() {
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
    void testPatientCombinedBehavior() {
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
        // Test inherited fields
        assertEquals(id, patient.getId(), "ID should match (inherited from Person)");
        assertEquals(name, patient.getName(), "Name should match (inherited from Person)");
        assertEquals(mobileNo, patient.getMobileNo(), "Mobile number should match (inherited from Person)");
        assertEquals(gender, patient.getGender(), "Gender should match (inherited from Person)");

        // Test Patient-specific fields
        assertEquals(age, patient.getAge(), "Age should match");
        assertEquals(address, patient.getAddress(), "Address should match");
        assertEquals(appointedDoctor, patient.getAppointedDoctor(), "Appointed doctor should match");
        assertEquals(room, patient.getRoom(), "Room should match");
        assertEquals(diagnosis, patient.getDiagnosis(), "Diagnosis should match");
        assertEquals(deposit, patient.getDeposit(), "Deposit should match");
    }
}