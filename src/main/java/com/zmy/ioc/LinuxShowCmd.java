package com.zmy.ioc;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 21:20 2022/1/18
 */
public class LinuxShowCmd implements ShowCmd {
    public String showCmd() {
        return "ls";
    }
}
