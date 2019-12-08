package org.jun.rpc.protocol.hello;

import java.io.Serializable;

/**
 * @ClassName HelloRequest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:17
 * @Version 1.0
 **/
public class HelloRequest implements Serializable {

    private String key;

    public HelloRequest() {
    }

    public HelloRequest(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HelloRequest{");
        sb.append("key='").append(key).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
