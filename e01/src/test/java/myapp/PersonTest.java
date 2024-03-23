package myapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    // Test name setter and getter
    @Test
    public void testSetName() {
        //Arrange
        String expectedName = "john";
        Person person = new Person();
        //Act
        person.setName(expectedName);
        //Assert
        assertEquals(expectedName, person.getName());
    }

    // Test for exception on setting an invalid name
    @Test
    public void setNameWithInvalidNameThrowsException() {
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, ()->person.setName(null));
        
    }

    // Test age setter and getter
    @Test
    public void testSetAge() {
        Person person = new Person();
        int expectesAge = 4;
        person.setAge(expectesAge);

        assertEquals(expectesAge, person.getAge());
    }

    // Test for exception on setting a negative age
    @Test
    public void setAgeWithNegativeValueThrowsException() {
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, ()->person.setAge(-4));
    }

    // Test hobby add
    @Test
    public void testAddHobby() {
        Person person = new Person();
        String ExpectedHobby = "Writting";
        person.addHobby(ExpectedHobby);
        assertTrue(person.getHobbies().contains(ExpectedHobby));
    }

    // Test hobby get
    @Test
    public void testGetHobbies() {
        Person person = new Person();
        String hobby1 = "Writting";
        String hobby2 = "Knitting";
        String hobby3 = "Swimming";
        List<String> ExpectedHobbies = new ArrayList<>();
        ExpectedHobbies.add(hobby1);
        ExpectedHobbies.add(hobby2);
        ExpectedHobbies.add(hobby3);
        person.addHobby(hobby1);
        person.addHobby(hobby2);
        person.addHobby(hobby3);
        assertEquals(ExpectedHobbies, person.getHobbies());
    }

    // Test person to string
    @Test
    public void testToString() {
        Person person = new Person();
        person.addHobby("knitting");
        person.setAge(44);
        person.setName("Joanna");
        String EpectedString =  "Joanna has 44 years old, and they like [knitting]";
        assertEquals(EpectedString, person.toString());
    }

    // Test for exception on adding a null or empty hobby
    @Test
    public void addHobbyWithInvalidValueThrowsException() {
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, ()->person.addHobby(""));
    }
}
