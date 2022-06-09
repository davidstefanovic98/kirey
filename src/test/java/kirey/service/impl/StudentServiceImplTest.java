package kirey.service.impl;

import kirey.entity.Student;
import kirey.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        /*
         * Create a new student with the following data:
         * firstName: "John"
         * lastName: "Doe",
         * city: "New York",
         * dateOfBirth: "1998-11-07",
         * dateOfAdmission: "2022-10-01"
         *
         * Age is calculated as the difference between the current year and the year of birth.
         */
        Student student = createStudent(
                "John",
                "Doe",
                "New York",
                LocalDate.of(1998, 11, 7),
                LocalDate.of(2022, 10, 1));
        /*
         * Create a new student with the following data:
         * firstName: "David"
         * lastName: "Stefanovic",
         * city: "Nis",
         * dateOfBirth: "1998-11-07",
         * dateOfAdmission: "2022-10-01"
         *
         * Age is calculated as the difference between the current year and the year of birth.
         */
        Student student1 = createStudent(
                "David",
                "Stefanovic",
                "Nis",
                LocalDate.of(1998, 11, 7),
                LocalDate.of(2022, 10, 1));
        studentRepository.saveAll(List.of(student, student1));
    }


    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    /**
     * This test checks if there are students with age greater than 20 who live in New York.
     * As we clearly see from the mock data, there is a student with age 20 who lives in New York.
     * Both conditions are met, so the test should return a list of one student.
     */
    @Test
    void findAllByCityAndAgeWithAgeGreaterThan20() {
        List<Student> students = studentRepository.findAllByCityAndDateOfBirth_Year("New York", LocalDate.now().minusYears(20).getYear());
        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
        assertEquals("New York", students.get(0).getCity());
    }

    /**
     * This test checks if there are students with age greater than 26 who live in New York.
     * As we clearly see from the mock data, there are no students with age greater than 26 and that are living in New York.
     * Both conditions are not met, and they should be met.
     * Therefore, the test should return an empty list.
     */
    @Test
    void findAllByCityAndAgeWithAgeGreaterThan26() {
        List<Student> students = studentRepository.findAllByCityAndDateOfBirth_Year("New York", LocalDate.now().minusYears(26).getYear());
        assertEquals(0, students.size());
    }

    /**
     * This test checks if there are students with age greater than 0 who live in Nis.
     * As we clearly see from the mock data, there is one student who meets the criteria.
     * Therefore, the test should a list of one student.
     */
    @Test
    void findAllByCityAndAgeWithAgeGreaterThan0() {
        List<Student> students = studentRepository.findAllByCityAndDateOfBirth_Year("Nis", LocalDate.now().minusYears(0).getYear());
        assertEquals(1, students.size());
        assertEquals("David", students.get(0).getFirstName());
        assertEquals("Stefanovic", students.get(0).getLastName());
        assertEquals("Nis", students.get(0).getCity());
    }

    /**
     * Utility method for creating a new student.
     * @param firstName First name of the student.
     * @param lastName Last name of the student.
     * @param city City in which the student lives.
     * @param dateOfBirth Date of birth of the student.
     * @param dateOfAdmission Date of admission of the student.
     * @return A new student with the given data.
     */
    public static Student createStudent(String firstName, String lastName , String city, LocalDate dateOfBirth, LocalDate dateOfAdmission) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setCity(city);
        student.setDateOfBirth(dateOfBirth);
        student.setDateOfAdmission(dateOfAdmission);
        return student;
    }
}