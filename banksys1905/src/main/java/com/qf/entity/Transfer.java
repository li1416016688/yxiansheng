package com.qf.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class Transfer {
    private Integer tid;
    private Integer uid;
    private Double money;
    private Date createTime;
    private String comment;
    private String consumType;
    private Double balance;
    public Transfer(){}

    public Transfer(Integer tid, Integer uid, Double money, Date createTime, String comment, String consumType, Double balance) {
        this.tid = tid;
        this.uid = uid;
        this.money = money;
        this.createTime = createTime;
        this.comment = comment;
        this.consumType = consumType;
        this.balance = balance;
    }
}
