package org.jun.rpc.protocol.core;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName TestProtocol
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 16:36
 * @Version 1.0
 **/
public class RPCRequest implements Serializable {
    public String clazz;

    public String method;

    public Object[] params;

    public RPCRequest() {
    }

    public RPCRequest(String clazz, String method, Object[] params) {
        this.clazz = clazz;
        this.method = method;
        this.params = params;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RPCRequest{");
        sb.append("clazz='").append(clazz).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append(", params=").append(params == null ? "null" : Arrays.asList(params).toString());
        sb.append('}');
        return sb.toString();
    }
}
