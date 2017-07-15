package io.vertx.playground;

import io.vertx.core.Vertx;

public class TimerExample {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

        vertx.setTimer(5000, l -> {
           System.out.println("Hello");
        });
    }

}
