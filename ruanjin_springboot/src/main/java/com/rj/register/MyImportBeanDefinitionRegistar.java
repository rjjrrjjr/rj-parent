package com.rj.register;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.rj.domain.People;

/**
 * Created by 10064028 on 2018/2/9.
 */
public class MyImportBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {
    /**
     * registerBeanDefinitions方法的参数有一个BeanDefinitionRegistry
     * BeanDefinitionRegistry可以用来往spring容器中注入bean
     * 如此，我们就可以在registerBeanDefinitions方法里面动态的注入bean
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(People.class);
        registry.registerBeanDefinition(People.class.getName(), beanDefinitionBuilder.getBeanDefinition());
    }
}
