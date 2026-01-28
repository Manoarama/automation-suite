package Springbootframwork.controller;
import Springbootframwork.model.Student;
import Springbootframwork.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student studentDetails) {

        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            return repository.save(student);
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }
}
