package kirey.service.impl;

import kirey.entity.Student;
import kirey.repository.StudentRepository;
import kirey.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    protected StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }
}
