package com.itany;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHold implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext=ac;
    }

    public static Object getBean(String beanName){return applicationContext.getBean(beanName);}

    public static <T> T getBean(Class<T> clazz){return applicationContext.getBean(clazz);}
}
