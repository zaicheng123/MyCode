package cn.jbit.service;

import cn.jbit.pojo.User;
import cn.jbit.utils.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserService {

    /**
     * 登录功能：
     * 返回1，代表存在该用户，登陆成功
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    int   loginUser(@Param("username") String username, @Param("password") String password) throws Exception;

    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    int  insertUser(User user) throws  Exception;

    /**
     * 返回用户列表
     * @return
     * @throws Exception
     */
    List<User> getUserList() throws Exception;

    /**
     * 报表信息导出用户信息
     */
    RespBean getExportUserList() throws Exception;

}
