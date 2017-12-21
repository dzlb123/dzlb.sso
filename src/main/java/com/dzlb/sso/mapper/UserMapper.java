package com.dzlb.sso.mapper;

import com.dzlb.sso.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by wuhai on 2017/12/20.
 */
public interface UserMapper {

    @Select("SELECT " +
            "id," +
            "user_key as userKey," +
            "login_name as loginName," +
            "login_password as loginPassword," +
            "user_name as userName," +
            "state," +
            "registry_time as registryTime," +
            "last_login_time as lastLoginTime " +
            " FROM sso_user")
    List<User> selectAll();

    @Select("SELECT " +
            "id," +
            "user_key as userKey," +
            "login_name as loginName," +
            "login_password as loginPassword," +
            "user_name as userName," +
            "state," +
            "registry_time as registryTime," +
            "last_login_time as lastLoginTime " +
            " FROM sso_user " +
            " WHERE id = #{id}")
    User selectById(Long id);


    @Select("SELECT " +
            "id," +
            "user_key as userKey," +
            "login_name as loginName," +
            "login_password as loginPassword," +
            "user_name as userName," +
            "state," +
            "registry_time as registryTime," +
            "last_login_time as lastLoginTime " +
            " FROM sso_user " +
            " WHERE login_name = #{loginName} AND login_password = #{loginPassword}")
    User loginSelect(String loginName,String loginPassword);

    @Insert("INSERT sso_user (user_key,login_name,login_password,user_name,state,registry_time,last_login_time) " +
            "VALUES(#{userKey},#{loginName},#{loginPassword},#{userName},#{state},#{registryTime},#{lastLoginTime})")
    void insert(User user);

    @Update("UPDATE sso_user SET login_name=#{loginName},login_password=#{loginPassword}," +
            "user_name=#{userName},state=#{state},last_login_time=#{lastLoginTime} WHERE id=#{id}")
    void update(User user);

    @Update("UPDATE sso_user SET last_login_time=#{lastLoginTime} WHERE id=#{id}")
    void updateloginTime(Long id,String lastLoginTime);

    @Delete("DELETE FROM sso_user WHERE id = #{id}")
    void delete(Long id);

}
