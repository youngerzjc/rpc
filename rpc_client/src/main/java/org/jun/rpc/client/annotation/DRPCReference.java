package org.jun.rpc.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName DRPCReference
 * @Description TODO
 * @Author zhangjunchai
 * @Date 2019/12/8 21:49
 * @Version 1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DRPCReference {

    String value() default "";  // 不填写的话，会默认使用field的接口来作为value

}
