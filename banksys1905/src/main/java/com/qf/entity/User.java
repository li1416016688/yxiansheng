package com.qf.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer uid;
    private String bankCode;
    private String password;
    private Double balance;
    private Integer state;

    public User() {
    }

    public User(Integer uid, String bankCode, String password, Double balance, Integer state) {
        this.uid = uid;
        this.bankCode = bankCode;
        this.password = password;
        this.balance = balance;
        this.state = state;
    }
}
