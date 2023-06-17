package com.example;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringConstant {
    String value() default "";
    String description() default "";
}

