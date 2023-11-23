package com.yupi.usercenter.service;
import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author：Victor_htq
 * @Package：com.yupi.usercenter.service
 * @Project：user-center
 * @name：UserServiceTest
 * @Date：2023/11/23 10:59
 * @Filename：UserServiceTest
 */

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("DogVictor");
        user.setUserAccount("123");
        user.setAvatarUrl("123@123.com");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }
}