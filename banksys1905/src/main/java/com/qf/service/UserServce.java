package com.qf.service;

import com.qf.entity.User;

public interface UserServce {

    public User login(String bankCode,String password);
    public Double findBalance(String bankCode);
}
