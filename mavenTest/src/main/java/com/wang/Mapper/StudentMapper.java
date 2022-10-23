package com.wang.Mapper;

import com.wang.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();
    Student selectById(int id);
}
