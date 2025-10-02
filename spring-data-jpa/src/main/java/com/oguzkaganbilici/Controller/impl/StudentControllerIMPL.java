package com.oguzkaganbilici.Controller.impl;

import com.oguzkaganbilici.Controller.InterfaceStudentsController;
import com.oguzkaganbilici.Entities.Student;
import com.oguzkaganbilici.Services.InterfaceStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControllerIMPL implements InterfaceStudentsController {

    @Autowired
    private InterfaceStudentsService studentsService;

    @PostMapping(path = "/save")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentsService.saveStudent(student);
    }

    @GetMapping(path = "/student-list")
    public List<Student> getAllStudents()
    {
        return studentsService.getAllStudents();
    }

    @GetMapping(path = "/student-list/name/{firstName}")
    public List<Student> findStudent(@PathVariable(name = "firstName") String firstName) {
        return studentsService.findStudent(firstName);
    }

    @GetMapping(path = "/student-list/id/{id}")
    public Student findByID(@PathVariable(name = "id") Integer ID){
        return studentsService.findByID(ID);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteByID(@PathVariable(name="id")Integer ID){
        studentsService.deleteByID(ID);
    }

    @PutMapping(path = "update/id/{id}")
    public Student updateStudent(@PathVariable(name = "id") Integer ID, @RequestBody Student newStudent){
        return studentsService.updateStudent(ID, newStudent);
    }
}
