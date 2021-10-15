package com.law.springdata.tutorials.jpqlandnativesql;

import com.law.springdata.tutorials.jpqlandnativesql.entities.Student;
import com.law.springdata.tutorials.jpqlandnativesql.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("Lawrence");
		student.setLastName("Chettur");
		student.setScore(90);

        Student student2 = new Student();
        student2.setFirstName("Mary");
        student2.setLastName("Ancy");
        student2.setScore(100);

		studentRepository.save(student);
		studentRepository.save(student2);
    }

    @Test
    public void testFindAllStudents() {
        System.out.println(studentRepository.findAllStudents());
    }


    @Test
    public void testFindAllStudentsPartialData() {
        List<Object[]> allStudentsPartialData = studentRepository.findAllStudentsPartialData();
        allStudentsPartialData.forEach(e -> {
            System.out.println(e[0]);
            System.out.println(e[1]);
        });
    }

    @Test
    public void testFindAllStudentsByFirstName() {
        System.out.println(studentRepository.findAllStudentsByFirstName("Mary"));
    }

    @Test
    public void testFindAllStudentForGivenScores() {
        System.out.println(studentRepository.findAllStudentForGivenScores(80, 100));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteStudentByFirstName() {
        studentRepository.deleteStudentByFirstName("Lawrence");
    }
}
