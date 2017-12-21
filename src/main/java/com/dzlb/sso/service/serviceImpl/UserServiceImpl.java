package com.dzlb.sso.service.serviceImpl;

import com.dzlb.sso.entity.User;
import com.dzlb.sso.mapper.UserMapper;
import com.dzlb.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuhai on 2017/12/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }


}
