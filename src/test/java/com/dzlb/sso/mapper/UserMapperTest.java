package com.dzlb.sso.mapper;

import com.dzlb.sso.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wuhai on 2017/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAllTest(){
        List<User> list = userMapper.selectAll();
        System.out.println(list);
    }

}
