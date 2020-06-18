package org.jun.rpc.client.proxy;

import org.jun.rpc.client.bean.DRPCReferenceObject;

import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 16:55
 * @Version 1.0
 **/
public class RPCProxyClient {

    public static <T> T clientProxy(DRPCReferenceObject object){

//        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),new ProxyHandle());
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class<?>[]{object.getIface()},new RemoteInvocationHandle(object));
    }
}
