package org.jun.rpc.server;

import org.jun.rpc.server.config.ServerConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @ClassName RPCServer
 * @Description rpc 服务端
 * @Author zhangjunchia
 * @Date 2019/12/8 16:19
 * @Version 1.0
 **/
public class RPCServer {


    private Executor executors = new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000));


    public RPCServer() {
    }

    public void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(ServerConfig.INSTANCE.getProperty("port")));
        while(true){
            Socket socket = serverSocket.accept();
            executors.execute(new RequestHandle(socket));
        }
    }


}
