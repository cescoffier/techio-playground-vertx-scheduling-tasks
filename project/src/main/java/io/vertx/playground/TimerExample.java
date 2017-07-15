package io.vertx.playground;

import io.vertx.core.Vertx;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class TimerExample {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

        vertx.setTimer(1000, l -> {
           System.out.println("Hello");
        });
    }

}
