package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");
//        personService.print();
        IMath math = (IMath) applicationContext.getBean("mathProxy");
        math.add();
        math.div();
    }
}
