package io.vertx.playground;

import io.vertx.playground.techio.Techio;
import org.junit.Test;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class PeriodicExampleTest {

    @Test
    public void test() {
        PeriodicExample.main();
        Techio.success(true);

        Techio.await(30);
    }
}