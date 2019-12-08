package org.jun.rpc.client.net;

import org.jun.rpc.client.config.ClientConfig;
import org.jun.rpc.protocol.core.RPCRequest;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName RPCNetTransport
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 20:05
 * @Version 1.0
 **/
public class RPCNetTransport {

    public Object send(RPCRequest request){

        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = new Socket(ClientConfig.INSTANCE.getProperty("host"), Integer.parseInt(ClientConfig.INSTANCE.getProperty("port")));
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

//            if(!returnType.getName().equals("void")){
            Object o = objectInputStream.readObject();
            return o;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
