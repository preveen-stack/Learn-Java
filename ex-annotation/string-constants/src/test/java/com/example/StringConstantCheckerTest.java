package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class StringConstantCheckerTest {
    @Test
    public void testStringConstants() throws Exception {
        // Get the list of annotated string constants from the Constants class
        Field[] fields = Constants.class.getFields();

        // Check that each annotated string constant is not empty
        for (Field field : fields) {
            if (field.isAnnotationPresent(StringConstant.class)) {
                String value = (String) field.get(null);
                StringConstant annotation = field.getAnnotation(StringConstant.class);
                Assertions.assertFalse(value.isEmpty(),
                    "The " + field.getName() + " string constant is empty");
                Assertions.assertFalse(annotation.value().isEmpty(),
                    "The " + field.getName() + " string constant annotation value is empty");
                Assertions.assertFalse(annotation.description().isEmpty(),
                    "The " + field.getName() + " string constant annotation description is empty");
            }
        }
    }
}

