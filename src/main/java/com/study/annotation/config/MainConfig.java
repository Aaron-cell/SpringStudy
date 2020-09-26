package com.study.annotation.config;

import com.study.annotation.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//通过注解扫描 以下包包路径 excludeFilters过滤掉那些路径或注解等
//FilterType.CUSTOM 自定义过滤规则 需要继承TypeFilter
@ComponentScan(value ="com.study.annotation",excludeFilters = {
    //@ComponentScan.Filter(type = FilterType.ANNOTATION ,classes = {Controller.class, Service.class})
    @ComponentScan.Filter(type = FilterType.CUSTOM ,classes = {MyTypeFilter.class})
})
public class MainConfig {
    /**
     * 通过注解方式
     * @return
     */
    @Bean("Person")
    public Person setPersonBeanToContext(){
        return new Person("Aaron","22");
    }
}
