package com.rj.selector;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.rj.anno.EnableLog;
import com.rj.domain.People;

/**
 * Created by 10064028 on 2018/2/8.
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("===============================beagin=======================");
        Set<String> types = annotationMetadata.getAnnotationTypes();
        for (String type : types){
            System.out.println(type);
        }
        //获取注解的属性信息
        System.out.println(annotationMetadata.getAllAnnotationAttributes(EnableLog.class.getName()));
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableLog.class.getName());
        for (Map.Entry<String, Object> entry : attributes.entrySet()){
            System.out.println(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof String[]){
                for (String str : (String[])value){
                    System.out.println(str);
                }
            }else {
                System.out.println(value);
            }
            System.out.println("----------------");
        }
        System.out.println("==============================end=======================");
        //这里可以获取到注解的详细信息，然后根据信息去动态的返回需要被spring容器管理的bean
        return new String[]{};
    }
}
