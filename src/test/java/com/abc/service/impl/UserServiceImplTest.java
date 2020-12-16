package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.service.iservice.IUserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest extends TestCase {

    @Autowired
    IUserService userService;


    @Test
    public void testUserExist() {
        Res res = userService.userExist("sss");
        System.out.println(res);
    }
}