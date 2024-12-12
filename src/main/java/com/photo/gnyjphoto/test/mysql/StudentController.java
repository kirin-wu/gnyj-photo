package com.photo.gnyjphoto.test.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    public StudentDao studentDao;

    @GetMapping("/students")
    @ResponseBody
    public Object getStudent(@RequestParam String id) {
        try {
            List listStudent = studentDao.getStudent(id);
            if (listStudent.isEmpty()) {
                return "null";
            }
            return listStudent.get(0);
        } catch (Exception e) {
            // 打印异常日志
            e.printStackTrace();
            return "Internal Server Error: " + e.getMessage();
        }
    }

    @PostMapping("/students")
    @ResponseBody
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
    @ResponseBody
    public String updateStudent(@RequestParam String id, @RequestParam String name){
        studentDao.updateStudent(id, name);
        return "ok";
    }

    @DeleteMapping("/students")
    @ResponseBody
    public String deleteStudent(@RequestParam String id){
        studentDao.deleteStudent(id);
        return "ok";
    }
}
