package org.jun.rpc.server.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName DRPC
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/8 20:43
 * @Version 1.0
 **/
@Target(ElementType.TYPE)   // 接口、类
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface DRPCService {

    Class value();


}
