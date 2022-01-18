package com.zmy.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 21:27 2022/1/18
 */
@Configuration
public class JavaConfig {
    @Bean("cmd")
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd() {
        return new WindowsShowCmd();
    }

    @Bean("cmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd() {
        return new LinuxShowCmd();
    }

    @Bean
    @Profile("dev")
    DataSource devDs() {
        DataSource ds = new DataSource();
        ds.setUrl("jdbc.mysql:///vhr");
        ds.setUsername("root");
        ds.setPassword("123");
        return ds;
    }

    @Bean
    @Profile("prod")
    DataSource prodDs() {
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://192.168.23.56:3306/vhr");
        ds.setUsername("root");
        ds.setPassword("fdasfasd3fdafasd");
        return ds;
    }
}
