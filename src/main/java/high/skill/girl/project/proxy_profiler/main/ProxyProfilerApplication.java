package high.skill.girl.project.proxy_profiler.main;

import high.skill.girl.project.proxy_profiler.proxy.CallHandler;
import high.skill.girl.project.proxy_profiler.proxy.Women;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class ProxyProfilerApplication {
    public static void main(String... args) throws IOException {

        Women me = new Women(26);
        CallHandler callHandler = new CallHandler(me);
        Class[] interfaces = new Class[]{Comparable.class};
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), interfaces, callHandler);

        Comparable<Women> c = (Comparable<Women>) proxy; // unchecked warning
        System.out.println(c.compareTo(new Women(45)));

        //org.openjdk.jmh.Main.main(args); // запуск раннера - запускает сгенерированные классы с бенчмарками
    }
}
