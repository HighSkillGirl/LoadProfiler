package high.skill.girl.project.proxy_profiler.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CallHandler implements InvocationHandler {

    private Object target;

    public CallHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("compareTo")) {
            return target.equals(args[0]) ? 1 : -1;
        }
        return null;
    }
}
