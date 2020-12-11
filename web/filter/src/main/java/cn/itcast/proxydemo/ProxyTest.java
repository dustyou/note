package cn.itcast.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    
    public static void main(String[] args) {
        //1. 创建真实对象
        final Lenovo lenovo = new Lenovo();
        //2. 动态代理增强lenovo对象
        /*
        * 3个参数:
        *   1. 类加载器: 真实对象.getClass().getClassLoader()
        *   2. 接口数组: 真实对象..getClass().getInterfaces()
        *   3. 处理器: new InvocationHandler()
        *   返回Object类型的对象, 强转为被代理对象的接口
        * */
        SaleComputer proxy_lenovo =(SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(),
                new InvocationHandler() {
            /*
            * 代理逻辑编写的方法, 代理对象调用的所有方法都会出发该方法执行
            * 参数:
            *   1. proxy: 代理对象
            *   2. method: 代理对象调用的方法, 被封装为的对象
            *   3. args: 代理对象调用方法时, 传递的实际参数
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                //执行被代理的方法, 获取被代理方法返回的结果
//                Object obj = method.invoke(lenovo, args);
//
//                System.out.println("该方法执行了");
//                //获取方法名称
//                System.out.println(method.getName());
//                //获取方法参数
//                System.out.println(args[0]);
//                return obj;
                
                if (method.getName().equals("sale")) {
                    //1. 增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    //3. 增强方法体执行逻辑
                    System.out.println("专车接送");
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    //2. 增强返回值
                    return obj+"+鼠标垫";
                } else {
                    //执行被代理对象的方法
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });
        
        //3. 调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
        proxy_lenovo.show();
    }
    
}
