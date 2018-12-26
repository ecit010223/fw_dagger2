package com.year2018.fw_dagger2.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Qulifier功能和@Named一样,并且@Named就是继承@Qulifier的,我们要怎么使用@Qulifier注解呢?答案就是自定义一个注解
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface YellowCloth {
}
