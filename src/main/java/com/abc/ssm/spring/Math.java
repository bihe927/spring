package com.abc.ssm.spring;

import org.springframework.stereotype.Component;

@Component("math")
public class Math implements IMath{

    @Override
    public void add() {
        System.out.println("a+b");
    }

    @Override
    public void sub() {
        System.out.println("a-b");
    }

    @Override
    public void mul() {
        System.out.println("a*b");
    }

    @Override
    public void div() {
        System.out.println("a/b");
    }
}
