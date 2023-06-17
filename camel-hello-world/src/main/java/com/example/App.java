package com.example;

/**
 * Hello world!
 *
 */
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class App {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();

    context.addRoutes(new RouteBuilder() {
      public void configure() {
        from("direct:start").to("stream:out");
      }
    });

    context.start();
    context.createProducerTemplate().sendBody("direct:start", "Hello, World!");
    Thread.sleep(1000);
    context.stop();
  }
}

