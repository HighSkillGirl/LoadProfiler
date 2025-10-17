package high.skill.girl.project.load_profiler.benchmarks;

import high.skill.girl.project.load_profiler.service.DynamicClassLoaderService;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class ActivityJournalBenchmarks {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void howLongDoesItTake() {

        DynamicClassLoaderService loaderService = new DynamicClassLoaderService(Path.of("load/ActivityJournal.jar"));

        loaderService.invokeMethod(
                "high.skill.girl.project.activity_journal.main.ActivityJournalApplication",
                "main",
                new Class[]{String[].class},
                (Object) new String[]{"journal show"}
        );
    }
}
