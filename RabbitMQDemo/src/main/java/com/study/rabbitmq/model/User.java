package com.study.rabbitmq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 16:28
 * @Description:
 */
@Data
public class User implements Serializable {

    private String name;

    private String address;

}
