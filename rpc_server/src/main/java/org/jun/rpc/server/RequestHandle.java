package org.jun.rpc.server;

import org.jun.rpc.protocol.core.RPCRequest;
import org.jun.rpc.server.config.ServerConfig;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName RequestHandle
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:31
 * @Version 1.0
 **/
public class RequestHandle implements Runnable{

    private Socket socket;

    ObjectInputStream objectInputStream ;
    ObjectOutputStream objectOutputStream;


    public RequestHandle(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.handle();
    }

    public void handle(){
        try {
            RPCRequest request = (RPCRequest)objectInputStream.readObject();
            Object result = invoke(request);
            response(request, result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(RPCRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String clazz = request.getClazz();
        Object obj = ServerConfig.INSTANCE.getObj(clazz);
        Class<?> aClass = Class.forName(clazz);

        Class[] paramsTypes = new Class[]{};
        Object[] params = request.getParams();
        if(params != null){
            paramsTypes = new Class[params.length];
            for(int i =0; i < params.length; i++){
                paramsTypes[i] = params[i].getClass();
            }
        }

        Method method = aClass.getMethod(request.getMethod(), paramsTypes);
        Object invoke = method.invoke(obj, params);

        return invoke;
    }

    public void response(RPCRequest request, Object result) throws IOException {
//        Class<?> returnType = method.getReturnType();
//        if(!returnType.getName().equals("void")){
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
//        }
    }
}
