package com.alog.rj.realms;

import java.util.Objects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.alog.rj.service.UserService;

/**
 * Created by 10064028 on 2018/1/12.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 为当前登录的Subject授予角色和权限
     * 本例中该方法的调用时机为需授权资源被访问时
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentUsername = (String) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        if (currentUsername != null && Objects.equals("jadyer", currentUsername)){
            simpleAuthorInfo.addRole("admin");
            simpleAuthorInfo.addStringPermission("admin:manage");
            System.out.println("已为用户[jadyer]赋予了[admin]角色和[admin:manage]权限");
            return simpleAuthorInfo;
        }else if (currentUsername != null && Objects.equals("玄玉", currentUsername)){
            System.out.println("当前用户[玄玉]无授权");
            return simpleAuthorInfo;
        }
        return null;
    }

    /**
     * 验证当前登录的Subject
     * 本例中该方法的调用时机为Controller中执行Subject.login()时
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("验证当前Subject时获取到的token为： " + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        if (Objects.equals("jadyer", token.getUsername())){
            SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo("jadyer", "jadyer", this.getName());
            this.setSession("currentUser", "jadyer");
            return authcInfo;
        }else if (Objects.equals("admin", token.getUsername())){
            SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo("玄玉", "xuanyu", this.getName());
            this.setSession("currentUser", "玄玉");
            return authcInfo;
        }
        return null;
    }

    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null){
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为【" + session.getTimeout() + "】毫秒");
            session.setAttribute(key, value);
        }
    }
}
