package kirey.controller;

import kirey.entity.Faculty;
import kirey.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties(@RequestParam(required = false) Specification<Faculty> specification,
                                                         @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(facultyService.findAll(specification, sort));
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer facultyId) {
        return ResponseEntity.ok(facultyService.findById(facultyId));
    }

    @PostMapping
    public ResponseEntity<Faculty> saveFaculty(@Valid @RequestBody Faculty faculty) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(facultyService.save(faculty));
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@Valid @RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping("/{facultyId}")
    public void deleteFacultyById(@PathVariable Integer facultyId) {
        facultyService.deleteById(facultyId);
    }


    @GetMapping("/search-faculty")
    public ResponseEntity<List<Faculty>> getAllFacultiesByNameAndCityAndNumberOfStudents(@RequestParam String name,
                                                                                         @RequestParam String city,
                                                                                         @RequestParam Integer numberOfStudents) {
        return ResponseEntity.ok(facultyService.findAllFacultiesByNameAndCityAndNumberOfStudents(name, city, numberOfStudents));
    }
}
