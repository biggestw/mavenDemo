package MybatisDemo.test;

import MybatisDemo.mapper.BrandMapper;
import MybatisDemo.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import java.util.List;

public class MybatisTest {
    /**
     查询所有
     */
    public static void selectAll(BrandMapper mapper){
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
    }

    /**
     * 根据id查询一个
     */
    public static void selectById(BrandMapper mapper, int id){
        Brand brand = mapper.selectById(id);
        System.out.println(brand);

    }

    /**
     *根据条件查询（模糊搜索）
     */
    public static void selectByCondition(BrandMapper mapper){
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setBrandName("%华为%");
        brand.setCompanyName("%华为%");

        List<Brand> brands = mapper.selectByCondition(brand);
        System.out.println(brands);
    }


    public static void selectByConditionSingle(BrandMapper mapper){
        Brand brand = new Brand();
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
    }

    public static void main(String[] args) throws Exception {
        //获取会话工厂
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        selectByConditionSingle(mapper);
        sqlSession.close();
    }

}
