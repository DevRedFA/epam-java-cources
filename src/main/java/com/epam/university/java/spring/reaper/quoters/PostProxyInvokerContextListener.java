package com.epam.university.java.spring.reaper.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] declaredMethods = originalClass.getDeclaredMethods();
                for (Method declaredMethod : declaredMethods) {
                    if(declaredMethod.isAnnotationPresent(PostProxy.class)){
                        Object bean = applicationContext.getBean(name);
                        Method method = bean.getClass().getMethod(declaredMethod.getName(), declaredMethod.getParameterTypes());
                        method.invoke(bean);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
