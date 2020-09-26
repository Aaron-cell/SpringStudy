package com.study.annotation.config;

import com.study.annotation.pojo.Person;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig2 {

    /**
     * 容器中bean默认是单实例
     * @return
     */
    @Scope(value = "singleton")
    /**
     * 可选值
     * 	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype 原型 懒汉模式 使用时加载bean
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton 单例 饿汉模式 容器启动时加载bean
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     */
    //ApplicationContext 容器默认是启动时加载bean
    @Lazy(value = true)
    @Bean(value ="Person")
    public Person setBean01ToContext(){
        System.out.println("创建Person的bean");
        return new Person("aaron","22");
    }

    @Bean(value ="test01")
    /**
     * Conditional 可以根据判断 在某种情况下 选择是否将bean注入到工厂中
     * 当标注在类上时，表示满足条件的时候，类下面的bean注解才会生效
     */
    @Conditional(value = {LinuxConditional.class})
    public Person setBeanToContext(){
        System.out.println("Linux环境下创建Person的bean");
        return new Person("test01","22");
    }
    @Bean(value ="test02")
    @Conditional(value = {WindowsConditional.class})
    public Person setBean02ToContext(){
        System.out.println("Windows环境下创建Person的bean");
        return new Person("test02","22");
    }
}
