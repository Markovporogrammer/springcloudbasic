package com.basic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//各种异常
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultException extends RuntimeException{

    String errorCode;

    String errorMsg;
}
