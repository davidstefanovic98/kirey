package kirey.service;

import kirey.entity.Faculty;

import java.util.List;

public interface FacultyService extends BaseService<Faculty> {

    //@Refactor: Too long method name, but Java...
    List<Faculty> findAllFacultiesByNameAndCityAndNumberOfStudents(String name, String city, Integer numberOfStudents);
}
