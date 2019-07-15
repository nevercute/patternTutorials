package pro.nevercute.tut.jbreak.partone.foreach;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 0)
@Warmup(iterations = 5, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class TrickyConsumingBenchmark {
    @Param(value = {"100", "10000"})
    public int N;

    private List<Integer> values;

    @Setup
    public void setup() {
        Random rand = new Random(12345);

        int size = N;
        values = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            values.add(rand.nextInt());
        }
    }

    @Benchmark
    public void forEachListBenchmark() {
        forEachList(values);
    }

    @Benchmark
    public void forEachStreamBenchmark() {
        forEachStream(values);
    }

    public void forEachList(List<Integer> values) {
        values.forEach(TrickyConsumer::consume);
    }

    public void forEachStream(List<Integer> values) {
        values.stream().forEach(TrickyConsumer::consume);
    }

    public static class TrickyConsumer {
        public static Integer value;

        public static void consume(Integer value) {
            if (! (value % 100 == 0)) {
                TrickyConsumer.value = value;
            }
        }
    }
}