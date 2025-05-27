package com.chatnest.chatnestuserservice01.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.chatnest.chatnestuserservice01.entity.User;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * Insert user
     * @param user as input
     * @return the number of lines that are affected
     */
    int insertUser(User user);

    /**
     * select based on the user
     * @param email as input
     * @return User 对象或 null
     */
    User selectByEmail(@Param("email") String email);

    /**
     * 根据手机号查询用户
     * @param phone 用户手机号
     * @return User 对象或 null
     */
    User selectByPhone(@Param("phone") String phone);
}
