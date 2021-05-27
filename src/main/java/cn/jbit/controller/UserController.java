package cn.jbit.controller;

import cn.jbit.pojo.User;
import cn.jbit.service.UserService;
import cn.jbit.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/8/30
 */
@Controller
@RequestMapping(value = "/user/info")
public class UserController {

        @Autowired
        private UserService  userService;

        @RequestMapping("/login")
        @ResponseBody
        public  Integer  loginUser(User user) throws Exception {

            int num=userService.loginUser(user.getUsername(),user.getPassword());
            System.out.println(num);
            if (num>0){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
            return num;
        }

        @RequestMapping("/userList")
        @ResponseBody
        public  List<User>  userList() throws Exception {

            List<User> userList =userService.getUserList();

            return userList;
        }

        //用户信息报表导出
        @GetMapping(value = "/export")
        @ResponseBody
        public ResponseEntity<byte[]>  exportData() throws Exception {
            System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈哈");
            List<User> list= (List<User>) userService.getExportUserList().getData();
            return POIUtils.employee2Excel(list);
        }
}
