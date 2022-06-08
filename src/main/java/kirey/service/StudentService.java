package kirey.service;

import kirey.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student> {

    List<Student> findAllStudentsByCityAndAge(String city, Integer age);
}
