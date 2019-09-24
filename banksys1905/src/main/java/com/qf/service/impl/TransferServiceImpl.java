package com.qf.service.impl;

import com.qf.dao.TransferDao;
import com.qf.dao.UserDao;
import com.qf.entity.Transfer;
import com.qf.entity.User;
import com.qf.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired(required = false)
    private TransferDao transferDao;
    @Autowired(required = false)
    private UserDao userDao;
    @Override
    public void transfer(String sourceCode, String descCode, Double money) {
        User user = userDao.findByCode(descCode);
        User sourceUser = userDao.findByCode(sourceCode);
        if (user==null){
    throw new RuntimeException("转账卡号输入有误");
}
        if (sourceCode.equals(descCode)){
            throw new RuntimeException("转账卡号不能一样");
        }
if (sourceUser.getBalance()<money){
    throw new RuntimeException("余额不足");
}

        Transfer stransfer = new Transfer();
        stransfer.setUid(sourceUser.getUid());
        stransfer.setMoney(0-money);
        stransfer.setBalance(sourceUser.getBalance()-money);
        transferDao.add(stransfer);

        Transfer dtransfer = new Transfer();
        dtransfer.setUid(user.getUid());
        dtransfer.setMoney(money);
        dtransfer.setBalance(user.getBalance()+money);
        transferDao.add(dtransfer);
    }
}
