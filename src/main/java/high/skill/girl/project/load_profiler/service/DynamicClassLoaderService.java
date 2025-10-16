package high.skill.girl.project.load_profiler.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class DynamicClassLoaderService {

    private final Path jarPath;

    public DynamicClassLoaderService(Path jarPath) {
        this.jarPath = jarPath;
    }

    public void invokeMethod(String className, String methodName, Class<?>[] paramTypes, Object... args) {
        URL[] urls = null;
        try {
            urls = new URL[]{ jarPath.toUri().toURL() };
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try (URLClassLoader loader = new URLClassLoader(urls, ClassLoader.getSystemClassLoader())) {
            Class<?> clazz = loader.loadClass(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod(methodName, paramTypes);
            method.invoke(instance, args);
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

}
