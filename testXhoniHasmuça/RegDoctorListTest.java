package Classes.testXhoniHasmuça;


import Classes.Doctor;
import Classes.RegDoctorList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class RegDoctorListTest {
    private RegDoctorList regDoctorList;

    @BeforeEach
    public void setUp() {
        regDoctorList = new RegDoctorList();
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        regDoctorList.addDoctor(doctor);
        assertEquals(1, regDoctorList.doctorCount);
        assertEquals("John Doe", regDoctorList.getDoctor(0).getName());
    }

    @Test
    public void testDoctorExists() {
        Doctor doctor = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        regDoctorList.addDoctor(doctor);
        int index = regDoctorList.doctorExists("John Doe");
        assertEquals(0, index);
    }

    @Test
    public void testDoctorExistsNotFound() {
        int index = regDoctorList.doctorExists("Nonexistent Doctor");
        assertEquals(-1, index);
    }

    @Test
    public void testCheckPassword() {
        Doctor doctor = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        regDoctorList.addDoctor(doctor);
        Doctor authenticatedDoctor = regDoctorList.checkPassword(0, "password123");
        assertNotNull(authenticatedDoctor);
        assertEquals("John Doe", authenticatedDoctor.getName());
    }

    @Test
    public void testCheckPasswordInvalid() {
        Doctor doctor = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        regDoctorList.addDoctor(doctor);
        Doctor authenticatedDoctor = regDoctorList.checkPassword(0, "wrongpassword");
        assertNull(authenticatedDoctor);
    }

    @Test
    public void testGetDoctorNames() {
        Doctor doctor1 = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        Doctor doctor2 = new Doctor("2", "Jane Doe", "0987654321", "Female", "Neurology", "2022-01-01", "BMDC5678", "password456");
        regDoctorList.addDoctor(doctor1);
        regDoctorList.addDoctor(doctor2);

        String[] doctorNames = regDoctorList.getDoctorNames();
        assertEquals(2, doctorNames.length);
        assertEquals("Dr. John Doe", doctorNames[0]);
        assertEquals("Dr. Jane Doe", doctorNames[1]);
    }

    @Test
    public void testFileNotFound() {
        // Rename or delete the "Files/DoctorList.txt" to test this manually.
        File file = new File("Files/DoctorList.txt");
        if (file.exists()) file.delete();  // Ensure the file does not exist.

        RegDoctorList testRegDoctorList = new RegDoctorList();
        assertEquals(0, testRegDoctorList.doctorCount);
    }

    @AfterEach
    public void tearDown() {
        // Clean up after tests if needed.
        regDoctorList=null;
    }
}