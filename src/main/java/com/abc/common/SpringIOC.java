package com.abc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOC {
    public static ApplicationContext getSpringIoc(){
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
