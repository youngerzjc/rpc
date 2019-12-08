package org.jun.rpc.server.impl;

import org.jun.rpc.protocol.hello.HelloRequest;
import org.jun.rpc.protocol.hello.HelloResponse;
import org.jun.rpc.protocol.hello.IHelloService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HelloServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:46
 * @Version 1.0
 **/
public class HelloServiceImpl implements IHelloService {

    public void hi() {
        System.out.println("method__hi");
    }

    public String getCurrentName() {
        return "currentName____" + "zjc";
    }

    public void sayHello(String name) {
        System.out.println("method__sayHello : " + name);
    }

    public String getNickName(String name) {
        return "nick_" + name;
    }

    public List<HelloResponse> getUserList(HelloRequest request){
        List<HelloResponse> list = new ArrayList<HelloResponse>();

        for(int i = 0; i < 5; i++){
            list.add(new HelloResponse(String.valueOf(i), i+request.getKey()));
        }
        return list;
    }

}
