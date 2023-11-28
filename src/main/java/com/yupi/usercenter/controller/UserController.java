package com.yupi.usercenter.controller;

import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.model.domain.request.UserLoginRequest;
import com.yupi.usercenter.model.domain.request.UserRegisterRequest;
import com.yupi.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.yupi.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.yupi.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/*
 * Author：Victor_htq
 * Package：com.yupi.usercenter.controller
 * Project：user-center
 * Name：UserController
 * Date：2023/11/23 16:47
 * Filename：UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * Param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    /**
     * 用户登录
     * Param userLoginRequest
     * Param request
     * @return
     */
    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        return userService.userLogin(userAccount, userPassword, request);
    }

    /**
     * 用户检索
     * Param username
     * Param request
     * @return
     */
    @GetMapping("/search")
    public List<User> searchUsers(String username, HttpServletRequest request) {
        if (roleCheck(request)) return null;
        return userService.searchUsers(username)
                .stream().map(user -> userService.getSafetyUser(user))
                .collect(Collectors.toList());
    }

    /**
     * 用户删除
     * Param id
     * Param request
     * @return
     */
    @GetMapping("/delete")
    public boolean deleteUser(Long id, HttpServletRequest request) {
        if (roleCheck(request)) return false;
        if (id <= 0) {
            return false;
        }
        return userService.removeById(id);
    }
    private static boolean roleCheck(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
            return true;
        }
        return false;
    }
}
