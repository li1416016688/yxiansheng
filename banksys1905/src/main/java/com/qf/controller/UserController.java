package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserServce;
import com.qf.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//@Controller
//@ResponseBody
@RestController
public class UserController {
    @Autowired
    UserServce userServce;
    @Autowired
    UserDao userDao;
    @RequestMapping("/login.do")
    public JsonResult login(String code, String password, HttpSession session) {

        try {
            User user = userServce.login(code, password);
            session.setAttribute(StrUtils.LOGIN_INFO,user);
            return new JsonResult(0, null);

        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1,e.getMessage());

        }

    }
    @RequestMapping("/balance.do")
    public JsonResult balance(HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_INFO);
        if (user==null){
            return new JsonResult(1,"还未登陆");
        }
        Double balance=userServce.findBalance(user.getBankCode());
        return new JsonResult(0,balance);
    }

}
