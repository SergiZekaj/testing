package Classes.systemErsidoDingo;

import Classes.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientSystemTest {

    @Test
    void testPatientCreation() {
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
        assertEquals(id, patient.getId(), "Patient ID should match");
        assertEquals(name, patient.getName(), "Patient name should match");
        assertEquals(mobileNo, patient.getMobileNo(), "Patient mobile number should match");
        assertEquals(gender, patient.getGender(), "Patient gender should match");
        assertEquals(age, patient.getAge(), "Patient age should match");
        assertEquals(address, patient.getAddress(), "Patient address should match");
        assertEquals(appointedDoctor, patient.getAppointedDoctor(), "Appointed doctor should match");
        assertEquals(room, patient.getRoom(), "Room should match");
        assertEquals(diagnosis, patient.getDiagnosis(), "Diagnosis should match");
        assertEquals(deposit, patient.getDeposit(), "Deposit should match");
    }

    @Test
    void testPatientDoctorInteraction() {
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

        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Act
        String newDoctor = "Dr. Johnson";
        patient.setAppointedDoctor(newDoctor);

        // Assert
        assertEquals(newDoctor, patient.getAppointedDoctor(), "Appointed doctor should be updated");
    }

    @Test
    void testPatientAdmission() {
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

        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Act
        String newRoom = "202";
        patient.setRoom(newRoom);

        // Assert
        assertEquals(newRoom, patient.getRoom(), "Room should be updated");
    }

    @Test
    void testPatientDiagnosisAndDeposit() {
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

        Patient patient = new Patient(id, name, mobileNo, gender, age, address, appointedDoctor, room, diagnosis, deposit);

        // Act
        String newDiagnosis = "Common Cold";
        String newDeposit = "7000";
        patient.setDiagnosis(newDiagnosis);
        patient.setDeposit(newDeposit);

        // Assert
        assertEquals(newDiagnosis, patient.getDiagnosis(), "Diagnosis should be updated");
        assertEquals(newDeposit, patient.getDeposit(), "Deposit should be updated");
    }

    @Test
    void testPatientEdgeCases() {
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
        assertEquals("", patient.getId(), "Patient ID should be empty");
        assertEquals("", patient.getName(), "Patient name should be empty");
        assertEquals("", patient.getMobileNo(), "Patient mobile number should be empty");
        assertEquals("", patient.getGender(), "Patient gender should be empty");
        assertEquals("", patient.getAge(), "Patient age should be empty");
        assertEquals("", patient.getAddress(), "Patient address should be empty");
        assertEquals("", patient.getAppointedDoctor(), "Appointed doctor should be empty");
        assertEquals("", patient.getRoom(), "Room should be empty");
        assertEquals("", patient.getDiagnosis(), "Diagnosis should be empty");
        assertEquals("", patient.getDeposit(), "Deposit should be empty");
    }
}