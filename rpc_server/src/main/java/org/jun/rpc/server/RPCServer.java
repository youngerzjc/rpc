package org.jun.rpc.server;

import org.jun.rpc.protocol.hello.IHelloService;
import org.jun.rpc.server.annotation.DRPCService;
import org.jun.rpc.server.config.ServerConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @ClassName RPCServer
 * @Description rpc 服务端
 * @Author zhangjunchia
 * @Date 2019/12/8 16:19
 * @Version 1.0
 **/
@Component
public class RPCServer implements ApplicationContextAware, InitializingBean  {

    private Executor executors = new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000));


    public void afterPropertiesSet() throws Exception {
        this.start();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("------ start init RPC service  ------ ");
        applicationContext.getBeansOfType(IHelloService.class);
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(DRPCService.class);
        Set<String> keySet = beansWithAnnotation.keySet();

        for(String dprc: keySet){
            Object bean = applicationContext.getBean(dprc);
            DRPCService drpcAnno= bean.getClass().getAnnotation(DRPCService.class);
            String value = drpcAnno.value().getName();
            ServerConfig.INSTANCE.register(value, bean);
            System.out.println("------ register key:" + value + "; impl:" + bean.getClass().getName() +  " ------ ");
        }
        System.out.println("------ end init RPC service  ------ ");
    }

    public RPCServer() {
    }

    public void start()  {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(ServerConfig.INSTANCE.getProperty("port")));
            while(true){
                Socket socket = serverSocket.accept();
                executors.execute(new RequestHandle(socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
