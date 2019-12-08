package org.jun.rpc.client.config;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName ClientConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:01
 * @Version 1.0
 **/
public class ClientConfig {

    public final static ClientConfig INSTANCE = new ClientConfig();

    public Properties properties = new Properties();
    public ClientConfig() {
        init();
    }

    private void init() {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("client.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {

        String port = ClientConfig.INSTANCE.getProperty("port");
        String host = ClientConfig.INSTANCE.getProperty("host");
        System.out.println(port);
        System.out.println(host);
    }

}
