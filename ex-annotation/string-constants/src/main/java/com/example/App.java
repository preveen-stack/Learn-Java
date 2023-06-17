package com.example;

/**
 * Hello world!
 *
 */
import java.lang.reflect.Field;

public class App {
    @StringConstant(value = "HELLO_WORLD", description = "A greeting message")
    public static final String MESSAGE = "Hello, world!";

    public static void main(String[] args) throws Exception {
        Field field = App.class.getField("MESSAGE");
        if (field.isAnnotationPresent(StringConstant.class)) {
            StringConstant annotation = field.getAnnotation(StringConstant.class);
            System.out.println(annotation.value() + ": " + MESSAGE);
            System.out.println("Description: " + annotation.description());
        }
    }
}

