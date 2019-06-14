import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-04 11:27
 */
public class TestCg {

    private Object target;

    private Object getInstance(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                methodProxy.invoke(o, args);
                return null;
            }
        });
        return enhancer.create();
    }

}
