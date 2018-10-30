package concurrent.act_of_concurrent.chapter4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Project:Exercise
 * Package:concurrent.act_of_concurrent.chapter4
 * Author:Alan Ruan
 * Date:2018-10-30 16:31
 * Description://TODO
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("commit")) {
            TimeUnit.MILLISECONDS.sleep(100);
        }
return null;
    }
}
    // 创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class[] { Connection.class }, new ConnectionHandler());
    }

}
