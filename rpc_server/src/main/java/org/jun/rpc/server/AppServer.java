package org.jun.rpc.server;

import org.jun.rpc.server.config.ServerConfig;
import org.jun.rpc.server.impl.HelloServiceImpl;

import java.io.IOException;

/**
 * @ClassName App
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 18:33
 * @Version 1.0
 **/
public class AppServer {
    public static void main(String[] args) {
        try {
            ServerConfig.INSTANCE.register("org.jun.rpc.protocol.hello.IHelloService", new HelloServiceImpl());
            new RPCServer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
