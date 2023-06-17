package com.example;

public class Constants {
    @StringConstant(value = "HELLO_WORLD", description = "A friendly greeting")
    public static final String HELLO_WORLD = "Hello, world!";

    @StringConstant(value = "GOODBYE_WORLD", description = "A farewell message")
    public static final String GOODBYE_WORLD = "Goodbye, world!";

    public static final String GREETING = "Welcome!"; // Not annotated
}

