package com.abc.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mathProxy")
public class MathProxy implements IMath{
    @Autowired
    private IMath math;

    private void on(){
        System.out.println("前置日志");
    }
    private void down(){
        System.out.println("后置日志");
    }
    @Override
    public void add() {
        on();
        math.add();
        down();
    }

    @Override
    public void sub() {
        on();
        math.sub();
        down();
    }

    @Override
    public void mul() {
        on();
        math.mul();
        down();
    }

    @Override
    public void div() {
        on();
        math.div();
        down();
    }
}
