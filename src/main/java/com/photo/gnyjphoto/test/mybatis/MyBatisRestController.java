package com.photo.gnyjphoto.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyBatisRestController {
    // 使用注解方式的 MyBatis
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "/studentBatis", method = RequestMethod.GET)
    public Object getStudent(@RequestParam Long id) {
        return studentMapper.getStudent(id);
    }


    @RequestMapping(value = "studentBatis", method = RequestMethod.POST)
    public String addStudentXML(@RequestBody Student student) {
        studentMapper.saveStudent(student);
        return "ok";
    }

    @RequestMapping(value = "/studentBatis", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student) {
        studentMapper.updateStudent(student);
        return "ok";
    }

    @RequestMapping(value = "/studentBatis", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam String id) {
        studentMapper.deleteStudent(id);
        return "ok";
    }


}

