package Classes.systemXhoniHasmuça;


import Classes.Doctor;
import Classes.RegDoctorList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegDoctorListSystem {
    private RegDoctorList regDoctorList;
    private final String filePath = "Files/DoctorList.txt";

    @BeforeEach
    public void setUp() {
        // Ensure the environment is clean before each test
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        regDoctorList = new RegDoctorList();
    }

    @Test
    public void testAddAndRetrieveDoctor() {
        // Adding a doctor and verifying their details
        Doctor doctor = new Doctor("1", "John Doe", "1234567890", "Male", "Cardiology", "2023-01-01", "BMDC1234", "password123");
        regDoctorList.addDoctor(doctor);

        assertEquals(1, regDoctorList.doctorCount);
        Doctor retrievedDoctor = regDoctorList.getDoctor(0);
        assertNotNull(retrievedDoctor);
        assertEquals("John Doe", retrievedDoctor.getName());
    }



    @Test
    public void testFileNotFoundHandling() {
        // Ensure file does not exist
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        // Initialize the system and verify it handles the missing file
        RegDoctorList newRegDoctorList = new RegDoctorList();
        assertEquals(0, newRegDoctorList.doctorCount);
    }



    @Test
    public void testInvalidFileFormatHandling() throws IOException {
        // Create a corrupt file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Invalid Data Format");
        }

        // Initialize the system and verify it handles invalid data gracefully
        RegDoctorList newRegDoctorList = new RegDoctorList();
        assertEquals(0, newRegDoctorList.doctorCount); // Expect system to initialize an empty list
    }

    @AfterEach
    public void tearDown() {
        // Clean up after tests
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        regDoctorList=null;
    }
}