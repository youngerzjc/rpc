package org.jun.rpc.client.proxy;

import org.jun.rpc.client.net.RPCNetTransport;
import org.jun.rpc.protocol.core.RPCRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName ProxyHandle
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 16:54
 * @Version 1.0
 **/
public class RemoteInvocationHandle implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RPCRequest rpcRequest = new RPCRequest(method.getDeclaringClass().getName(), method.getName(), args);
        RPCNetTransport rpcNetTransport = new RPCNetTransport();
        return rpcNetTransport.send(rpcRequest);
    }
}
