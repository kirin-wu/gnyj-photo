package com.photo.gnyjphoto.test.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getStudent(String id) {
        List<Map<String, Object>> studentList = jdbcTemplate.queryForList("select * from student where id = ?", id);
        return studentList;
    }

    public void saveStudent(String id,String name){
        StringBuffer sql = new StringBuffer();
        sql.append(" insert into student ");
        sql.append(" (id,name) ");
        sql.append(" values ");
        sql.append(" (?,?) ");
        jdbcTemplate.update(sql.toString(),new Object[]{id,name});
    }

    public void updateStudent(String id, String name) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" update student ");
            sql.append(" set name = ? ");
            sql.append(" where id = ? ");

            // 确保参数顺序与 SQL 语句中的占位符一致
            jdbcTemplate.update(sql.toString(), new Object[]{name, id});
        } catch (Exception e) {
            e.printStackTrace();  // 输出错误信息
            throw new RuntimeException("Failed to update student", e);
        }
    }

    public void deleteStudent(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from student ");
        sql.append(" where id = ? ");
        jdbcTemplate.update(sql.toString(), new Object[] { id });
    }

}
