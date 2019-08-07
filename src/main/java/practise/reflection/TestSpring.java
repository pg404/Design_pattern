package practise.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Project: SomethingAboutJava
 * Package: practise.reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:54
 * Description: //TODO 使用反射方式，首先准备一个配置文件，就叫做spring.txt吧
 * 在测试类TestSpring中，首先取出类名称和方法名，然后通过反射去调用这个方法。
 *
 * 当需要从调用第一个业务方法，切换到调用第二个业务方法的时候，不需要修改一行代码，也不需要重新编译，
 * 只需要修改配置文件spring.txt，再运行即可。
 *
 * 这也是Spring框架的最基本的原理，只是它做的更丰富，安全，健壮。
 *
 */
public class TestSpring {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception{

        File springConfigFile = new File("d:\\IDEA Projects\\SomethingAboutJava\\src\\spring.txt");
        Properties springConfig = new Properties();

        springConfig.load(new FileInputStream(springConfigFile));
        String className = (String) springConfig.get("class");
        String methodName = (String) springConfig.get("method");

        System.out.println(className + " \n" +methodName);

        //根据类名称获取类对象
        Class clazz = Class.forName(className);
        //根据方法名称，获取方法对象
        Method method = clazz.getMethod(methodName);
        //获取构造器
        Constructor constructor = clazz.getConstructor();
        //根据构造器，实例化出对象
        Object service =  constructor.newInstance();
        //调用对象的指定方法
        method.invoke(service);




    }

}
