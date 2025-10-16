package high.skill.girl.project.load_profiler.benchmarks;

import high.skill.girl.project.load_profiler.service.DynamicClassLoaderService;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class MyTestProject2Benchmarks {

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void howLongDoesItTake() {

            DynamicClassLoaderService loaderService = new DynamicClassLoaderService(Path.of("load/my-test-project2.jar"));

            loaderService.invokeMethod(
                    "Main",
                    "main",
                    new Class[]{String[].class},
                    (Object) new String[]{}
            );
    }
}
