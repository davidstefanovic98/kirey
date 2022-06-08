package kirey.service.impl;

import kirey.entity.Faculty;
import kirey.repository.FacultyRepository;
import kirey.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl extends BaseServiceImpl<Faculty> implements FacultyService {

    private final FacultyRepository facultyRepository;

    protected FacultyServiceImpl(FacultyRepository facultyRepository) {
        super(facultyRepository);
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> findAllFacultiesByNameAndCityAndNumberOfStudents(String name, String city, Integer numberOfStudents) {
        return facultyRepository.findAllByNameAndCity(name, city)
                .stream()
                .filter(faculty -> faculty.getStudents().size() > numberOfStudents)
                .collect(Collectors.toList());
    }
}
