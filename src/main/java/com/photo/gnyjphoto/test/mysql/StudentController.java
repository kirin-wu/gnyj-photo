package com.photo.gnyjphoto.test.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentDao studentDao;

    @GetMapping("/students")
    public Object getStudent(@RequestParam String id) {
        List listStudent = studentDao.getStudent(id);
        if (listStudent.isEmpty()) {
            return "null";
        }
        return listStudent.get(0);
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String id, @RequestParam String name) {
        System.out.println(id);
        System.out.println(name);
        try {
            System.out.println("Adding student with id: " + id + ", name: " + name);
            studentDao.saveStudent(id, name);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }


    @PutMapping("/students")
    public String updateStudent(@RequestParam String id, @RequestParam String name){
        studentDao.updateStudent(id, name);
        return "ok";
    }

    @DeleteMapping("/students")
    public String deleteStudent(@RequestParam String id){
        studentDao.deleteStudent(id);
        return "ok";
    }
}
