package com.imxiaomai.base.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 为解决注释规范化而创造的一个东西，可以在代码级别进行复用，进而做进一步的自动化处理
* */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
public @interface Comment {

	public String value() default "";

}
