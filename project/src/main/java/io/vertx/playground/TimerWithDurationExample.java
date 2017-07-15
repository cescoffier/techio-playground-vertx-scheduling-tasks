package io.vertx.playground;

import io.vertx.core.Vertx;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class TimerWithDurationExample {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();
        vertx.setTimer(TimeUnit.SECONDS.toMillis(5), l -> {
           System.out.println("Hello");
        });
    }

}
