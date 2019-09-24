package com.qf.service.impl;

import com.qf.common.JsonResult;
import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServce {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String bankCode, String password) {
        User u = (User) userDao.findByCode(bankCode);
        if (u==null){
            throw new RuntimeException("卡号错误");
        }
        if(!u.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return u;

    }

    @Override
    public Double findBalance(String bankCode) {

            User user = userDao.findByCode(bankCode);
            if(user==null){
                throw new RuntimeException("账号不存在");
            }
            return user.getBalance();
        }

}
