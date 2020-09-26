import com.study.annotation.config.MainConfig;
import com.study.annotation.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestAnnotation {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            System.out.println("bean名称：->"+beanDefinitionName);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器启动....");
//        Object person1 = applicationContext.getBean("Person");
//        Object person2 = applicationContext.getBean("Person");
//        System.out.println(person1==person2);

    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器启动....");
        //当前环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String system = environment.getProperty("os.name");
        System.out.println("当前系统:->"+system);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
    }
}
