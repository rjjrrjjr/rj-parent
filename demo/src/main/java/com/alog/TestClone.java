package com.alog;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;

import com.alog.entity.EntityA;
import com.alog.entity.EntityB;
import com.alog.entity.EntityC;
import com.alog.entity.EntityD;

/**
 * Created by 10064028 on 2018/1/8.
 */
public class TestClone {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        EntityA a = new EntityA();
        EntityB b = new EntityB();
        EntityC c = new EntityC();
        EntityD d = new EntityD();
        c.setA(a);
        c.setB(b);

        BeanUtils.copyProperties(d, c);
        System.out.println(c.getA() == d.getA());
        System.out.println(c.getB() == d.getB());
        System.out.println("=============================");

        DozerBeanMapper mapper = new DozerBeanMapper();
        EntityD map = mapper.map(c, EntityD.class);
        System.out.println(map.getA() == c.getA());
        System.out.println(map.getB() == c.getB());

    }
}
