package high.skill.girl.project.proxy_profiler.main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class ProxyProfilerApplication {
    public static void main(String... args) throws IOException {

        Path jarPath = Path.of("load/my-test-project.jar");
        Path jarPath2 = Path.of("load/my-test-project2.jar");
        URL[] urls = { jarPath.toUri().toURL(), jarPath2.toUri().toURL() }; // отрабатывает первый найденный по имени класс

        try (URLClassLoader loader = new URLClassLoader(urls)) {
            Class<?> clazz = loader.loadClass("Main");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod("main", String[].class);

            String[] loadedArgs = new String[]{};
            method.invoke(instance, (Object) loadedArgs);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
