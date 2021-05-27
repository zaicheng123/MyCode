package cn.jbit.service.impl;

import cn.jbit.dao.UserMapper;
import cn.jbit.pojo.User;
import cn.jbit.service.UserService;
import cn.jbit.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/8/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int loginUser(String username, String password) throws Exception {
        return userMapper.loginUser(username,password);
    }

    @Override
    public int insertUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userMapper.getUserList();
    }

    @Override
    public RespBean getExportUserList() throws Exception {

        RespBean respBean=new RespBean();

        List<User> list=userMapper.getUserList();

        respBean.setData(list);
        return respBean;
    }
}
