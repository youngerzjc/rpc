package org.jun.rpc.protocol.hello;

import java.io.Serializable;

/**
 * @ClassName HelloResponse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 17:17
 * @Version 1.0
 **/
public class HelloResponse  implements Serializable {

    public String id;

    public String name;

    public HelloResponse() {
    }

    public HelloResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HelloResponse{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
