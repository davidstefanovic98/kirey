package kirey.service.impl;

import kirey.entity.Student;
import kirey.repository.StudentRepository;
import kirey.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    private final StudentRepository studentRepository;

    protected StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudentsByCityAndAge(String city, Integer age) {
        return studentRepository.findAllByCityAndDateOfBirth_Year(city, LocalDate.now().minusYears(age).getYear());
    }
}
