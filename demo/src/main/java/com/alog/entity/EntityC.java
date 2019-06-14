package com.alog.entity;

import java.io.Serializable;

/**
 * Created by 10064028 on 2018/1/8.
 */
public class EntityC implements Serializable {

    private static final long serialVersionUID = 49289613532431113L;

    private EntityA a;

    private EntityB b;

    public EntityA getA() {
        return a;
    }

    public void setA(EntityA a) {
        this.a = a;
    }

    public EntityB getB() {
        return b;
    }

    public void setB(EntityB b) {
        this.b = b;
    }
}
