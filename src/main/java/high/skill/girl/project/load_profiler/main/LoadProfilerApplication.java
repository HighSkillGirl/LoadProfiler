package high.skill.girl.project.load_profiler.main;

import java.io.IOException;

public class LoadProfilerApplication {
    public static void main(String... args) throws IOException {
        org.openjdk.jmh.Main.main(args); // запускает специального раннера для бенчмарок
    }
}
