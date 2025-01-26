package Classes.integrationXhoniHasmuça;


import Classes.Doctor;
import Classes.RegDoctorList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RegDoctorListIntegration {

    private RegDoctorList regDoctorList;
    private static final String FILE_PATH = "Files/DoctorList.txt";

    @BeforeEach
    public void setUp() throws IOException {
        // Create a fresh DoctorList.txt file before each test
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // Ensure the directory exists
        file.createNewFile();

        // Initialize the RegDoctorList object
        regDoctorList = new RegDoctorList();
    }

    @Test
    public void testAddDoctorAndDoctorExists() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("D001", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC123", "password123");

        // Add the doctor to the list
        regDoctorList.addDoctor(doctor);

        // Check if the doctor exists in the list
        int index = regDoctorList.doctorExists("John Doe");
        assertNotEquals(-1, index, "Doctor should exist in the list");

        // Verify the doctor's details
        Doctor retrievedDoctor = regDoctorList.getDoctor(index);
        assertEquals("D001", retrievedDoctor.getId(), "Doctor ID should match");
        assertEquals("John Doe", retrievedDoctor.getName(), "Doctor name should match");
        assertEquals("Cardiology", retrievedDoctor.getDepartment(), "Doctor department should match");
    }

    @Test
    public void testCheckPassword() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("D002", "Jane Doe", "0987654321", "Female", "Neurology", "2023-02-01", "BMDC456", "password456");

        // Add the doctor to the list
        regDoctorList.addDoctor(doctor);

        // Check if the password is correct
        int index = regDoctorList.doctorExists("Jane Doe");
        Doctor loggedInDoctor = regDoctorList.checkPassword(index, "password456");

        assertNotNull(loggedInDoctor, "Doctor should be able to log in with correct password");
        assertEquals("Jane Doe", loggedInDoctor.getName(), "Logged in doctor's name should match");

        // Check with incorrect password
        Doctor invalidLoginDoctor = regDoctorList.checkPassword(index, "wrongpassword");
        assertNull(invalidLoginDoctor, "Doctor should not be able to log in with incorrect password");
    }

    @Test
    public void testFileReading() {
        // Manually write some data to the file
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            fw.write("D005\n");
            fw.write("Charlie\n");
            fw.write("3333333333\n");
            fw.write("Male\n");
            fw.write("Dermatology\n");
            fw.write("2023-05-01\n");
            fw.write("BMDC202\n");
            fw.write("password202\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reinitialize RegDoctorList to read from the file
        regDoctorList = new RegDoctorList();

        // Verify that the doctor was read from the file
        int index = regDoctorList.doctorExists("Charlie");
        assertNotEquals(-1, index, "Doctor should exist in the list");

        Doctor retrievedDoctor = regDoctorList.getDoctor(index);
        assertEquals("D005", retrievedDoctor.getId(), "Doctor ID should match");
        assertEquals("Charlie", retrievedDoctor.getName(), "Doctor name should match");
        assertEquals("Dermatology", retrievedDoctor.getDepartment(), "Doctor department should match");
    }
}