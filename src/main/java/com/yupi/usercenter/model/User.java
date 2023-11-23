package com.yupi.usercenter.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author：Victor_htq
 * @Package：com.yupi.usercenter.model
 * @Project：user-center
 * @name：User
 * @Date：2023/11/22 15:46
 * @Filename：User
 */
@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
