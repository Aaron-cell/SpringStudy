package com.study.annotation.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class LinuxConditional implements Condition {

    /**
     *
     * @param context 工厂
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取系统环境
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if(!property.contains("Windows")){
            return true;
        }
        return false;
    }
}
