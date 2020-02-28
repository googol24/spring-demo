# SPRING IOC
> 基本概念
- Spring就是一个IOC的容器，IOC容器负责实例化具体的bean，可以动态装配

> 依赖注入类型
  - setters
  - 构造方法
  - 接口注入
  
> Bean的scope（生存周期）
- singleton 单例（默认）
- prototype 原型
- request(web相关)
- session(web相关)
- global session(web相关)

> 普通属性注入、集合注入
- 集合注入支持set list map以及数组等数据类型的属性注入

> 自动装配Autowire
 - bean的autowire属性 : byType byName
 <bean id="userServiceAutowired" class="com.googol24.spring.service.UserService" autowire="byName">

> 生命周期
- bean的lazy_init属性：true表示ctx初始化的时候bean不进行初始化，即使用context.getBean("beanId")取出bean时触发再初始化，否则的话在容器启动的时候进行bean初始化
        - true:在bean初始化的时候进行初始化
        - false:在容器初始化的时候进行初始化
- init_method destroy_method表示初始化bean和关闭bean的时候调用的方法，例如destroy-method可以用于关闭数据库连接的时候释放连接使用。不适合和scope为prototype的bean一起使用

> annotation Spring的注解
- @Autowired
  当 Spring 容器启动时，AutowiredAnnotationBeanPostProcessor 将扫描 Spring 容器中所有 Bean，当发现 Bean 中拥有 @Autowired 注释时就找到和其匹配(默认按类型匹配)的 Bean，并注入到对应的地方中去