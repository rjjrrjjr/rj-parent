package com.alog.rj.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * Created by 10064028 on 2018/1/9.
 */
public class TestShiro implements Realm {
    @Override
    public String getName() {

        System.out.println("run method: public String getName() {...");
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        System.out.println("run method: public boolean supports(AuthenticationToken authenticationToken) {...");
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("run method: public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {...");
        return null;
    }
}
