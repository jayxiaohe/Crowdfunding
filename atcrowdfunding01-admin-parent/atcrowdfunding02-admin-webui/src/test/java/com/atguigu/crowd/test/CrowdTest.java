package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;

// 在类上标记必要的注解，Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdTest {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private AdminMapper adminMapper;
    
    @Autowired
    private AdminService adminService;
    
    @Test
    public void testTx() {
        Admin admin = new Admin(null, "jerry", "123456", "杰瑞", "jerry@qq.cim", null);
        adminService.saveAdmin(admin); 
    }
    
    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        logger.debug("Hello I am debug level!");
        logger.debug("Hello I am debug level!");
        logger.debug("Hello I am debug level!");
        
        logger.info("info level");
        logger.info("info level");
        logger.info("info level");
        
        logger.warn("warn level !!!!");
        logger.warn("warn level !!!!");
        logger.warn("warn level !!!!");
        
        logger.error("error level!!!!!!!!!!!!");
        logger.error("error level!!!!!!!!!!!!");
        logger.error("error level!!!!!!!!!!!!");
    }
    
    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "herman", "123456", "何鹏涛", "hpt@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("影响的行数= " + count);
    }
    
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}