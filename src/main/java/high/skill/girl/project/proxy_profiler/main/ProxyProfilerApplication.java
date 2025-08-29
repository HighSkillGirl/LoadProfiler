package high.skill.girl.project.proxy_profiler.main;

import java.io.IOException;

public class ProxyProfilerApplication {
    public static void main(String... args) throws IOException {
        org.openjdk.jmh.Main.main(args); // запуск раннера - запускает сгенерированные классы с бенчмарками
    }
}
