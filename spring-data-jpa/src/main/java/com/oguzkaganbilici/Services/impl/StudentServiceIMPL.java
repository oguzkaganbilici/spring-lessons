package com.oguzkaganbilici.Services.impl;

import com.oguzkaganbilici.Entities.Student;
import com.oguzkaganbilici.Repository.StudentRepository;
import com.oguzkaganbilici.Services.InterfaceStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements InterfaceStudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return  studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public List<Student> findStudent(String firstName){
        return studentRepository.findByFirstNameIgnoreCase(firstName);
    }

    public Student findByID(Integer ID){
        return studentRepository.findById(ID).orElse(null);
    }

    public void deleteByID(Integer ID){
        Student theStudent = findByID(ID);
        if(theStudent != null){
            studentRepository.delete(theStudent);
        }
        else {
            System.out.println("There is not any student with this ID");
        }
    }

    public Student updateStudent(Integer ID, Student newStudent){
        Student theStudent = findByID(ID);
        if(theStudent != null){
            theStudent.setFirstName(newStudent.getFirstName());
            theStudent.setLastName(newStudent.getLastName());
            theStudent.setBirthOfDate(newStudent.getBirthOfDate());

            return studentRepository.save(theStudent);
        }

        return null;
    }

}
