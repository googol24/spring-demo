# AOP
> 实现原理：动态代理
- InvocationHandler
    - InvocationHandler接口是Proxy代理实例的调用处理程序实现的一个接口，每一个Proxy代理实例都有一个关联的调用处理程序；在代理实例调用方法时，方法调用被编码分派到调用处理程序的invoke方法
    - 每一个动态代理类的调用处理程序都必须实现InvocationHandler接口，并且每个代理类的实例都关联到了实现该接口的动态代理类调用处理程序中，当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用
- Proxy
    - Proxy类就是用来创建一个代理对象的类，它提供了很多方法，但是我们最常用的是newProxyInstance方法来创建一个代理类的对象
    ```
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
    ```
    - 参数loader：一个classloader对象，定义了由哪个ClassLoader对象对生成的代理类进行加载
    - 参数interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法
    - 参数h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用
