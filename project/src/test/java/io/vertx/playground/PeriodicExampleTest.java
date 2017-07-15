package io.vertx.playground;

import io.vertx.playground.techio.StreamRecorder;
import io.vertx.playground.techio.Techio;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.core.Is.is;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class PeriodicExampleTest {

    @Test
    public void test() {
        StreamRecorder record = TestUtils.record(System.out);
        AtomicInteger found = new AtomicInteger();
        record.addLineAnalyzer(line -> {
            if (line.contains("Hello 1")) {
                found.incrementAndGet();
            }
            if (line.contains("Hello 2")) {
                found.incrementAndGet();
            }
            if (line.contains("Hello 3")) {
                found.incrementAndGet();
            }
        });

        PeriodicExample.main();
        await().untilAtomic(found, is(3));
        Techio.success(true);
    }
}