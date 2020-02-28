# SPRING AOP ANNOTATION
> AOP
- AOP（Aspect Oriented Programming，面向切面编程），把某一类问题集中在一个地方进行处理，比如处理程序中的点击事件、打印日志等。
- AOP是对OOP思维方式的有力补充，好处是可以动态地添加和删除在切面上的逻辑而不影响原来的执行代码
- AOP应用场景：日志记录，权限验证，效率检查，事务管理等
> AspectJ
- AspectJ是一个面向切面编程的框架（一个专门用于产生各种动态代理的框架，被Spring所采用），它扩展了Java语言。
  AspectJ定义了AOP语法，它有一个专门的编译器用来生成遵守Java字节编码规范的Class文件。AspectJ还支持原生的Java，只需要加上AspectJ提供的注解即可。
> AOP的常见名词
- JointPoint：连接点,需要代理的目标对象中的方法就是一个连接点
- PointCut：切入点，也即连接点的集合
- Weaving：织入，也即给原始对象补充业务逻辑的过程
- Advice：通知，就字面意思，但是有2个部分组成，通知内容和通知到哪里去
    - Before ：前置通知，在连接点方法前调用
    - After ：后置通知，在连接点方法后调用(finally)
    - AfterReturning：返回通知，在连接点方法执行并正常返回后调用，要求连接点方法在执行过程中没有发生异常
    - AfterThrowing：异常通知，当连接点方法异常时调用
    - Around：环绕通知，它将覆盖原有方法，但是允许你通过反射调用原有方法
- Aspect：切面。包括连接点，切点，通知的一个载体。（如果用AspectJ它就是一个类，如果用springXML的时候它就是一个标签）并且交给spring管理
- Target object：目标对象，原始对象，也即被代理的对象
- AOP proxy：代理对象，包含了原始对象的代码和增强后的代码的那个对象
> 切点匹配表达式
- execution：可以定义到方法的的最小粒度是参数的返回类型，修饰符，包名，类名，方法名，Spring AOP主要也是使用这个匹配表达式。
- within：只能定义到类
- this：当前生成的代理对象的类型匹配
- target：目标对象类型匹配
- args：只针对参数