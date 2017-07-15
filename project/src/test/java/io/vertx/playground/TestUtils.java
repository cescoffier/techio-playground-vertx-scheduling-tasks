package io.vertx.playground;

import io.vertx.core.Vertx;
import io.vertx.playground.techio.StreamRecorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtils {

    protected static Vertx vertx = Vertx.vertx();
    private static StreamRecorder recorder;

    public static void shutdown() {
        if (recorder != null) {
            StreamRecorder.stop(recorder);
            recorder = null;
        }

        if (vertx != null) {
            vertx.close();
            vertx = null;
        }
    }

    public static StreamRecorder record(PrintStream out) {
        recorder = StreamRecorder.record(out);
        return recorder;
    }
}