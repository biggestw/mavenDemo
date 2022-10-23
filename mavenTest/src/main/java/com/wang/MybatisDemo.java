package com.wang;

import com.wang.Mapper.StudentMapper;
import com.wang.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        // 加载Mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        //List<Student> students = sqlSession.selectList("test.selectAll");
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectAll();
//        Student student = sqlSession.selectOne("test.selectOne");
//
//        System.out.println(student);
//        int i = sqlSession.update("test.updateOne");
//        if(i > 0){
//            System.out.println("数据更新成功" + i);
//        }

        for (Student student : students) {
            System.out.println("姓名" + student.getName() + "\n学号" + student.getId() +"\n性别" + student.getSex());
            System.out.println("-----------------");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
