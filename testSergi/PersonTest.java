package Classes.testSergi;

import Classes.Person;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Creating a concrete subclass for testing purposes
class TestPerson extends Person {
    public TestPerson(String id, String name, String mobileNo, String gender) {
        super(id, name, mobileNo, gender);
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private Person person;

    @BeforeEach
    void setup() {
        // Initialize a concrete instance of the abstract Person class
        person = new TestPerson("P001", "Sergi Zekaj", "1234567890", "Male");
    }

    @Test
    void testGetId() {
        assertEquals("P001", person.getId(), "The ID should be P001");
    }

    @Test
    void testSetId() {
        person.setId("P002");
        assertEquals("P002", person.getId(), "The ID should be updated to P002");
    }

    @Test
    void testGetName() {
        assertEquals("Sergi Zekaj", person.getName(), "The name should be Sergi Zekaj");
    }

    @Test
    void testSetName() {
        person.setName("Vesa Malaj");
        assertEquals("Vesa Malaj", person.getName(), "The name should be updated to Vesa Malaj");
    }

    @Test
    void testGetMobileNo() {
        assertEquals("1234567890", person.getMobileNo(), "The mobile number should be 1234567890");
    }

    @Test
    void testSetMobileNo() {
        person.setMobileNo("0987654321");
        assertEquals("0987654321", person.getMobileNo(), "The mobile number should be updated to 0987654321");
    }

    @Test
    void testGetGender() {
        assertEquals("Male", person.getGender(), "The gender should be Male");
    }

    @Test
    void testSetGender() {
        person.setGender("Female");
        assertEquals("Female", person.getGender(), "The gender should be updated to Female");
    }
}

