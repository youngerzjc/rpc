package org.jun.rpc.client.bean;

/**
 * @ClassName DRPCReferenceObject
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 22:04
 * @Version 1.0
 **/
public class DRPCReferenceObject {
    private String value;

    private Class<?> iface;


    public DRPCReferenceObject(String value, Class<?> iface) {
        this.value = value;
        this.iface = iface;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class<?> getIface() {
        return iface;
    }

    public void setIface(Class<?> iface) {
        this.iface = iface;
    }
}
