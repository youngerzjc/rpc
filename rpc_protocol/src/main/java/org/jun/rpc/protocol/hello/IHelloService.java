package org.jun.rpc.protocol.hello;

import java.util.List;

/**
 * @ClassName IHelloService
 * @Description TODO
 * @Author zhangjunchai
 * @Date 2019/12/8 17:16
 * @Version 1.0
 **/
public interface IHelloService {

    void hi();

    void sayHello(String name);

    String getCurrentName();

    String getNickName(String name);


    List<HelloResponse> getUserList(HelloRequest request);
}
