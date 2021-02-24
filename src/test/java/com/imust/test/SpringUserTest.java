package com.imust.test;

import com.imust.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUserTest {
    @Test
    public void test() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println("user = " + user);
    }
}
