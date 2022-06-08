package kirey.repository;

import kirey.entity.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student> {

    List<Student> findAllByCityAndAgeGreaterThan(String city, Integer age);
}
