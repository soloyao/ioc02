package com.zmy.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 21:29 2022/1/18
 */
public class Main {
    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
        DataSource ds3 = ctx.getBean("ds,ds1,ds2", DataSource.class);
        System.out.println("ds3 = " + ds3);
    }

    private static void m3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
//        DataSource ds = ctx.getBean(DataSource.class);
//        DataSource ds1 = ctx.getBean(DataSource.class);
//        System.out.println(ds == ds1);
        DataSource ds3 = ctx.getBean("ds,ds1,ds2", DataSource.class);
        System.out.println("ds3 = " + ds3);
    }

    /**
     * profile环境切换
     */
    private static void m2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource ds = ctx.getBean(DataSource.class);
        DataSource ds1 = ctx.getBean(DataSource.class);
        System.out.println(ds == ds1);
    }

    /**
     * 条件注解
     */
    private static void m1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        String s = cmd.showCmd();
        System.out.println("s = " + s);
    }
}
