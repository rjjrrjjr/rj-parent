package com.alog.rj.realms;

import java.util.Objects;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * Created by 10064028 on 2018/1/10.
 */
public class MyRealm implements Realm {
    @Override
    public String getName() {
        System.out.println("获取Realm名称 ing..........................");
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        System.out.println("验证token类型 ing.....................");
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("验证用户名密码 ing....................");

        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        if (!Objects.equals("zhang", userName)){
            throw new UnknownAccountException();
        }
        if (!Objects.equals("123", password)){
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(userName, password, this.getName());
    }
}
