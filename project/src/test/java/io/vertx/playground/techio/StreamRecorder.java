package io.vertx.playground.techio;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class StreamRecorder extends FilterOutputStream {

    public static StreamRecorder record(PrintStream stream) {
        StreamRecorder recorder = new StreamRecorder(stream);
        System.setOut(new PrintStream(recorder));
        return recorder;
    }

    public static void stop(StreamRecorder recorder) {
        System.setOut((PrintStream) recorder.out);
    }

    private StringBuilder output = new StringBuilder();
    private StringBuilder line = new StringBuilder();
    private List<Consumer<String>> sensors = new ArrayList<>();

    public StreamRecorder(PrintStream out) {
        super(out);
    }

    @Override
    public synchronized void write(int b) throws IOException {
        if ((char) b == '\n') {
            analyze();
            line = new StringBuilder();
        } else {
            line.append((char) b);
        }
        
        output.append((char) b);
        super.write(b);
    }

    private void analyze() {
        String last = line.toString();
        for (Consumer<String> consumer : sensors) {
            consumer.accept(last);
        }
    }

    public synchronized String getOutput() {
        return output.toString();
    }

    public synchronized StreamRecorder addLineAnalyzer(Consumer<String> sensor) {
        sensors.add(sensor);
        return this;
    }

}
