package com.jason.bookparadise.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2016/12/13.
 */
@Aspect
public class TestAspect {

    @Before("execution(* com.jason.bookparadise.service.TestService.*(..))")
    public void testBefore(){
        System.out.println("Test AOP Before Run");
    }

}
