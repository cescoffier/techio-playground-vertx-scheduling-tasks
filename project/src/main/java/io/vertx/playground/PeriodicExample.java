package io.vertx.playground;

import io.vertx.core.Vertx;

public class PeriodicExample {

    private static int counter = 0;

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

        long timerId = vertx.setPeriodic(1000, id -> {
           System.out.println("Hello " + ++counter);
        });
    }

}
