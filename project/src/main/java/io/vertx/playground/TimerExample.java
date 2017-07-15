package io.vertx.playground;

import io.vertx.core.Vertx;

public class TimerExample {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();
        System.out.println("Starting, waiting for greetings");
        vertx.setTimer(5000, l -> {
           System.out.println("Hello");
        });
    }

}
