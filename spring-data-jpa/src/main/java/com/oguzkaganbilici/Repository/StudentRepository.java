package com.oguzkaganbilici.Repository;

import com.oguzkaganbilici.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    List<Student> findByFirstNameIgnoreCase(String firstName);
}
