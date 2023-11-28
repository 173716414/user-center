package com.yupi.usercenter.service;

import com.yupi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Author Victo
* Description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-11-23 10:53:34
*/

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * Param userAccount
     * Param userPassword
     * Param checkPassword
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * Param userAccount
     * Param userPassword
     * @return 返回脱敏后用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * Param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    List<User> searchUsers(String username);
}
