package cn.jbit.controller;

import cn.jbit.pojo.User;
import cn.jbit.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootVueApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() throws Exception {

        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("123123");
        int num=userService.loginUser(user.getUsername(),user.getPassword());

        System.out.println("登陆成功为1，不成功为0："+num);

        /*List<User> list=userService.getUserList();

        for (User user:list){
            System.out.println(user);
        }*/


    }

}
