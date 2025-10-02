package com.oguzkaganbilici.Services;

import com.oguzkaganbilici.Entities.Student;

import java.util.List;

public interface InterfaceStudentsService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public List<Student> findStudent(String firstName);
    public Student findByID(Integer ID);
    public void deleteByID(Integer ID);
    public Student updateStudent(Integer ID, Student newStudent);
}
