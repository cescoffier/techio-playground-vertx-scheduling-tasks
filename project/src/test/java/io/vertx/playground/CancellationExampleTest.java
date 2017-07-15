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
public class CancellationExampleTest {

    @Test
    public void test() {
        StreamRecorder record = TestUtils.record(System.out);
        AtomicInteger found = new AtomicInteger();
        record.addLineAnalyzer(line -> {
            if (line.contains("Hello")) {
                found.incrementAndGet();
            }
        });

        CancellationExample.main();
        await().untilAtomic(found, is(2));
        Techio.success(true);
    }
}