package org.jun.rpc.client.spring.post;

import org.jun.rpc.client.annotation.DRPCReference;
import org.jun.rpc.client.bean.DRPCReferenceObject;
import org.jun.rpc.client.proxy.RPCProxyClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @ClassName DSpringBeanPostProcessor
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 21:45
 * @Version 1.0
 **/
@Component
public class DSpringBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, String beanName) throws BeansException {

        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback(){
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                if(field.isAnnotationPresent(DRPCReference.class)){

                    DRPCReference drpcRef = field.getAnnotation(DRPCReference.class);

                    DRPCReferenceObject drpcReferenceObject = new DRPCReferenceObject(drpcRef.value(), field.getType());
                    Object serviceProxy = RPCProxyClient.clientProxy(drpcReferenceObject);
                    field.setAccessible(true);
                    field.set(bean, serviceProxy);
                    System.out.println("autowire to objName: " + beanName + "-- field: " + field.getName());
                }
            }
        });

        return super.postProcessAfterInstantiation(bean, beanName);
    }
}
