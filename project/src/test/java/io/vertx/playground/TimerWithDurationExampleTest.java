package io.vertx.playground;

import io.vertx.playground.techio.StreamRecorder;
import io.vertx.playground.techio.Techio;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.core.Is.is;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class TimerWithDurationExampleTest {


    @Test
    public void test() {
        StreamRecorder record = TestUtils.record(System.out);
        AtomicBoolean found = new AtomicBoolean();
        record.addLineAnalyzer(line -> {
            if (line.contains("Hello")) {
                found.set(true);
            }
        });

        TimerWithDurationExample.main();
        await().atMost(30, TimeUnit.SECONDS).untilAtomic(found, is(true));
        Techio.success(true);

        Techio.await(30);
    }

}