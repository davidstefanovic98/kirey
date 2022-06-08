package kirey.controller;

import kirey.entity.Student;
import kirey.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) Specification<Student> specification,
                                                        @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(studentService.findAll(specification, sort));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.findById(studentId));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.save(student));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
    }


    @GetMapping("/search-student")
    public ResponseEntity<List<Student>> getAllStudentsByCityAndAge(@RequestParam String city,
                                                                    @RequestParam Integer age) {
        return ResponseEntity.ok(studentService.findAllStudentsByCityAndAge(city, age));
    }
}
