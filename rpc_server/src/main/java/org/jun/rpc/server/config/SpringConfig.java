package org.jun.rpc.server.config;

import org.jun.rpc.server.RPCServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 20:58
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "org.jun.rpc")
public class SpringConfig {

//    @Bean
//    public RPCServer rpcServer(){
//        return new RPCServer();
//    }

}
