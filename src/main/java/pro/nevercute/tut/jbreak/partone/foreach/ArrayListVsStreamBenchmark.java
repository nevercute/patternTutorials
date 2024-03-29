/*package pro.nevercute.tut.jbreak.partone.foreach;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.util.NullOutputStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 0)
@Warmup(iterations = 5, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(value = TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class ArrayListVsStreamBenchmark {
    @Param(value = {"1", "10", "100", "1000", "10000"})
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

    @State(value = Scope.Benchmark)
    public static class PrintStreamHolder {
        PrintStream ps;

        @Setup(value = Level.Iteration)
        public void setup() {
            ps = new PrintStream(new NullOutputStream());
        }
    }

    @Benchmark
    public void forEachListBenchmark(PrintStreamHolder psh) {
        forEachList(values, psh.ps);
    }

    @Benchmark
    public void forEachStreamBenchmark(PrintStreamHolder psh) {
        forEachStream(values, psh.ps);
    }

    public void forEachList(List<Integer> values, PrintStream ps) {
        values.forEach(ps::println);
    }

    public void forEachStream(List<Integer> values, PrintStream ps) {
        values.stream().forEach(ps::println);
    }
}*/