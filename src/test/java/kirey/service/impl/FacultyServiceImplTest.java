package kirey.service.impl;

import kirey.entity.Faculty;
import kirey.entity.Student;
import kirey.repository.FacultyRepository;
import kirey.repository.StudentRepository;
import kirey.service.FacultyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacultyServiceImplTest {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student = createStudent(
                "John",
                "Doe",
                "New York",
                LocalDate.of(1998, 11, 7),
                LocalDate.of(2022, 10, 1));
        Student student1 = createStudent(
                "David",
                "Stefanovic",
                "Nis",
                LocalDate.of(1998, 11, 7),
                LocalDate.of(2022, 10, 1));
        studentRepository.saveAll(List.of(student, student1));
        Faculty faculty = createFaculty(
                "Faculty of Mathematics and Informatics",
                "Novi Sad",
                List.of(student, student1));
        Faculty faculty1 = createFaculty(
                "Faculty of Physics",
                "Beograd",
                List.of(student, student1));
        facultyRepository.saveAll(List.of(faculty, faculty1));
    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
        facultyRepository.deleteAll();
    }

    /**
     * This test checks if there are faculties with the name "Faculty of Mathematics and Informatics",
     * city "Novi Sad", and a number of students greater or equal to 2.
     * As we clearly see from the mock data, there is such faculty.
     * Since the conditions are met, so the service returns a list of one faculty.
     */
    @Test
    void findAllFacultiesByNameAndCityAndNumberOfStudents() {
        List<Faculty> faculties = facultyService.findAllFacultiesByNameAndCityAndNumberOfStudents(
                "Faculty of Mathematics and Informatics",
                "Novi Sad",
                2);
        assertEquals(1, faculties.size());
        assertEquals("Faculty of Mathematics and Informatics", faculties.get(0).getName());
        assertEquals("Novi Sad", faculties.get(0).getCity());
        assertEquals(2, faculties.get(0).getStudents().size());
    }

    /**
     * This test checks if there are faculties with the name "Blabla",
     * city "Blabla", and a number of students greater or equal to 5.
     * As we clearly see from the mock data, there is no such faculty,
     * so the service returns an empty list.
     */
    @Test
    void findAllFacultiesByNameAndCityAndNumberOfStudentsWithNoParametersMet() {
        List<Faculty> faculties = facultyService.findAllFacultiesByNameAndCityAndNumberOfStudents(
                "Blabla",
                "Blabla",
                5);
        assertEquals(0, faculties.size());
    }

    /**
     * Utility method for creating a new faculty.
     * @param name Name of the faculty.
     * @param city City in which faculty is located.
     * @param students List of students that are enrolled in the faculty.
     * @return New faculty with the given data.
     */
    public static Faculty createFaculty(String name, String city, List<Student> students) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setCity(city);
        faculty.setStudents(students);
        return faculty;
    }

    /**
     * See {@link StudentServiceImplTest#createStudent(String, String, String, LocalDate, LocalDate)}
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