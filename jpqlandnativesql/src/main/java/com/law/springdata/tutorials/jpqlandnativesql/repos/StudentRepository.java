package com.law.springdata.tutorials.jpqlandnativesql.repos;

import com.law.springdata.tutorials.jpqlandnativesql.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>:min and score<:max")
    List<Student> findAllStudentForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName = :firstName")
    void deleteStudentByFirstName(@Param("firstName") String firstName);

}
