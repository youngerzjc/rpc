package org.jun.rpc.server;

import org.jun.rpc.protocol.hello.IHelloService;
import org.jun.rpc.server.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @ClassName App
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 18:33
 * @Version 1.0
 **/
public class AppServer {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) applicationContext).start();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefin: beanDefinitionNames){
            System.out.println(beanDefin);
        }
//        IHelloService bean = applicationContext.getBean("HelloServiceImpl", IHelloService.class);
//        bean.hi();
    }
}
