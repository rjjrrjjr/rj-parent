package com.rj.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.rj.selector.MyImportSelector;

/**
 * Created by 10064028 on 2018/2/8.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportSelector.class)
public @interface EnableLog {
    String[] name() default {};

    int age() default 1;
}
