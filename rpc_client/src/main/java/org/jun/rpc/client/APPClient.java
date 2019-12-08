package org.jun.rpc.client;

import org.jun.rpc.client.proxy.RPCProxyClient;
import org.jun.rpc.protocol.hello.HelloRequest;
import org.jun.rpc.protocol.hello.HelloResponse;
import org.jun.rpc.protocol.hello.IHelloService;

import java.util.List;

/**
 * @ClassName RPCClient
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 16:27
 * @Version 1.0
 **/
public class APPClient {

    public static void main(String[] args) {

        IHelloService helloService = RPCProxyClient.clientProxy(IHelloService.class);

        System.out.println("---------调用 method: hi---------");
        helloService.hi();

        System.out.println("---------调用 method: sayHello---------");
        helloService.sayHello("i am client");

        System.out.println("---------调用 method: getCurrentName---------");
        String currentName = helloService.getCurrentName();
        System.out.println("currentName: " + currentName);

        System.out.println("---------调用 method: getNickName---------");
        String mic = helloService.getNickName("mic");
        System.out.println(mic);

        System.out.println("---------调用 method: getUserList---------");
        List<HelloResponse> list = helloService.getUserList(new HelloRequest("xx"));
        System.out.println(list);

    }
}
