package Springbootframwork;
import Springbootframwork.model.Student;
import Springbootframwork.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
        // Simple test to check Spring context loads
    }

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Test Student");
        student.setAge(21);
        student.setEmail("test@student.com");

        Student saved = studentRepository.save(student);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0);
    }

    @Test
    void testFindStudent() {
        Student student = new Student();
        student.setName("Find Me");
        student.setAge(22);
        student.setEmail("findme@student.com");

        studentRepository.save(student);

        Student found = studentRepository.findById(student.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Find Me");
    }
}

