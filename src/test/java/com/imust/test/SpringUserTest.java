package com.imust.test;

import com.imust.entity.user.User;
import com.imust.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUserTest {
    @Test
    public void userTest() {
        // 加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        // 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println("userService = " + userService);
    }
}
