package kirey.repository;

import kirey.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student> {

    @Query("select s from Student s where s.city = ?1 and year(s.dateOfBirth) <= ?2")
    List<Student>  findAllByCityAndDateOfBirth_Year(String city, int year);
}
