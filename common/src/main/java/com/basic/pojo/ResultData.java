package com.basic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {

    //返回编码
    private int code;

    //返回消息
    private String msg;

    //返回数据
    private T data;
}
