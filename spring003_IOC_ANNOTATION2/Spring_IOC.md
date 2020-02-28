# SPRING ANNOTATION
> annotation Spring的注解
- @Autowired
  当 Spring 容器启动时，AutowiredAnnotationBeanPostProcessor 将扫描 Spring 容器中所有 Bean，当发现 Bean 中拥有 @Autowired 注释时就找到和其匹配(默认按类型匹配)的 Bean，并注入到对应的地方中去
    - 默认按类型注入（byType）
    - 如果想使用byName进行注入，可以用@Qualifier注解进行指定
    - 不建议使用在private field上，破坏封装
    - 如果使用在setter上，@Qualifier注解需要写在参数上
- @Resource
    - JSR-250 规范提案里面定义的一个annotation
    - 默认情况下是按照byName的scope进行注入，如果没相同的name，就按照byType来
    - 也可以在注解里根据参数name或者type具体指定按照某种scope进行注入。name和type都指定时，找的是name和type都符合条件的bean
- @Component
    - 指定某个Bean（某各类的一个对象）为一个组件
    - bean组件初始化的名字默认为类名首字母小写
    - 可以指定初始化bean的名字
    - 相同的注解：@Service @Controller @Repository
    - 这个注解相当于把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
    
- @Scope注解
    - 相当于bean的xml配置文件里面的scope属性
- @PostConstruct与@PreDestroy
    - 分别相当于bean的xml配置文件里面的init-method属性和destroy-method属性