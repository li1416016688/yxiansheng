package com.qf.common;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JsonResult {
    private  Integer code;//0表示成功 ，1表示失败
    private  Object info;//具体信息

    public JsonResult() {
    }

    public JsonResult(Integer code, Object info) {
        this.code = code;
        this.info = info;
    }
}
