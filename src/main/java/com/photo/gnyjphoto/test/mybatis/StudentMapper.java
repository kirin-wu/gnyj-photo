package com.photo.gnyjphoto.test.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper{

    // 对应 XML 中同样的方式，支持一对多，支持一对一
    // 一个学生对应多个书包
    // 一个学生对应一个班主任
    // 如果有几个类似的查询，无法像 XML 中可以抽取出公共的
    // 只能每次 copy 到新方法
    Student getStudent(@Param("id") Long id);

//    List<SchoolBag> findSchoolBagsByStudentId(@Param("studentId") Long studentId);
//    // 一个学生对应一个班主任的查询结果集 SQL 以及 Result 配置
//    Teacher findTeacherByStudentId(@Param("studentId") Long studentId);

    List<Student> getStudents();
    // 新增学生
    void saveStudent(@Param("student") Student student);
    // 修改学生
    void updateStudent(@Param("student") Student student);
    // 删除学生
    void deleteStudent(@Param("id") String id);
}