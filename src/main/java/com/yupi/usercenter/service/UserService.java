package com.yupi.usercenter.service;

import com.yupi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Victo
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-11-23 10:53:34
*/

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return 返回脱敏后用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
}
