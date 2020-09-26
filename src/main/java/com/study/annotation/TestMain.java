package com.study.annotation;


import com.study.annotation.config.MainConfig;
import com.study.annotation.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    /**
     * 1.通过Beans.xml的方式 2.通过配置类的方式
     * @param args
     */
    public static void main(String[] args) {
        /*
        1.通过xml方式
         */
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
//        //getBean 可通过id获取bean 也可通过类型获取
//        //Person person = (Person) applicationContext.getBean("Person");
//        Person person = applicationContext.getBean(Person.class);
//        System.out.println(person.toString());
        /*
            2.通过注解方式
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("Person");
        System.out.println(person.toString());
        //查看Person 在容器中的名字
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String beanName : beanNamesForType){
            System.out.println(beanName);
        }
    }
}
