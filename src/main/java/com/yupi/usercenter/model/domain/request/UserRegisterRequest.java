package com.yupi.usercenter.model.domain.request;

/**
 * @Author：Victor_htq
 * @Package：com.yupi.usercenter.model.domain.request
 * @Project：user-center
 * @name：UserRegisterRequest
 * @Date：2023/11/23 16:55
 * @Filename：UserRegisterRequest
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}