package com.alog.rj.controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alog.rj.util.VerifyCodeUtil;

/**
 * Created by 10064028 on 2018/1/12.
 */
@Controller
@RequestMapping(value = "/mydemo")
public class LoginController {

    @RequestMapping("/getVerifyCodeImage")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
        request.getSession().setAttribute("verifyCode", verifyCode);
        System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String userName, String password){
        String resultPageUrl = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        String submitCode = WebUtils.getCleanParam(request, "verifyCode");
        System.out.println("用户[" + userName + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
        System.out.println(verifyCode.toString().toLowerCase());
        System.out.println(StringUtils.equals(verifyCode.toString().toLowerCase(), submitCode.toLowerCase()));
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode.toString().toLowerCase(), submitCode.toLowerCase())){
            request.setAttribute("message_login", "验证码不正确");
            return resultPageUrl;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        Subject currentUser = SecurityUtils.getSubject();
        try {
            System.out.println("对用户[" + userName + "]进行登录验证..验证开始");
            currentUser.login(token);
            System.out.println("对用户[" + userName + "]进行登录验证..验证通过");
            resultPageUrl += "main";
        }catch(UnknownAccountException uae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message_login", "未知账户");
        }catch(IncorrectCredentialsException ice){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message_login", "密码不正确");
        }catch(LockedAccountException lae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message_login", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message_login", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            request.setAttribute("message_login", "用户名或密码不正确");
        }

        if (currentUser.isAuthenticated()){
            System.out.println("用户[" + userName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        }else {
            token.clear();
        }
        return resultPageUrl;
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX  + "/";
    }
}
