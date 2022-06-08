package kirey.service.impl;

import kirey.entity.Student;
import kirey.repository.StudentRepository;
import kirey.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    private final StudentRepository studentRepository;

    protected StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
        this.studentRepository = baseRepository;
    }

    @Override
    public List<Student> findAllStudentsByCityAndAge(String city, Integer age) {
        return studentRepository.findAllByCityAndAgeGreaterThan(city, age);
    }
}
