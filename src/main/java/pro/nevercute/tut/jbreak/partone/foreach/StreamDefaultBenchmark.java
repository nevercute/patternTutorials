/*package pro.nevercute.tut.jbreak.partone.foreach;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.util.NullOutputStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 0, jvmArgsAppend = "-XX:-UseBiasedLocking")  
@Warmup(iterations = 5, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 2_000, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(value = TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class StreamDefaultBenchmark {
    static int N = 10000;

    static List<Integer> values;

    static {
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
    public void forEachStreamBenchmark(PrintStreamHolder psh) {
        forEachStream(values, psh.ps);
    }

    @Benchmark
    public void forEachParallelStreamBenchmark(PrintStreamHolder psh) {
        forEachParallelStream(values, psh.ps);
    }

    public void forEachStream(List<Integer> values, PrintStream ps) {
        values.stream().forEach(ps::println);
    }

    public void forEachParallelStream(List<Integer> values, PrintStream ps) {
        values.parallelStream().forEach(ps::println);
    }
}                                                    */