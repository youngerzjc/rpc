package org.jun.rpc.client.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 16:55
 * @Version 1.0
 **/
public class RPCProxyClient {

    public static <T> T clientProxy(Class<T> interfaces){

//        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),new ProxyHandle());
        return (T)Proxy.newProxyInstance(interfaces.getClassLoader(),new Class<?>[]{interfaces},new RemoteInvocationHandle());
    }
}
