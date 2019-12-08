package org.jun.rpc.server.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName ServerConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:33
 * @Version 1.0
 **/
public class ServerConfig {
    public final static ServerConfig INSTANCE = new ServerConfig();

    public Properties properties = new Properties();

    public Map<String, Object> map = new HashMap<String, Object>();

    public ServerConfig() {
        init();
    }

    private void init() {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("server.properties");
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

    public void register(String key , Object obj){
        map.put(key, obj);
    }

    public Object getObj(String key){
        return map.get(key);
    }



}
