package com.zmy.ioc;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 21:19 2022/1/18
 */
public class WindowsShowCmd implements ShowCmd {
    public String showCmd() {
        return "dir";
    }
}
