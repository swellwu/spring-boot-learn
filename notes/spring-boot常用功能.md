## 事件机制
事件继承ApplicationEvent，
订阅者实现ApplicationListener<Event>
发布者使用applicationContext.publishEvent(event)发布事件。
## 异步与多线程支持
@Async&@EnableAsync注解来支持异步和多线程，实现 AsyncConfigurer 接口来配置ThreadPoolTaskExecutor。
## 计划任务
使用@Scheduled实现计划任务，具体设置见此注解参数。@EnableScheduling开启计划任务。
## 拦截器配置
1. 定义拦截器：
继承HandlerInterceptorAdapter，覆盖相关方法。
2. 配置拦截器
继承WebMvcConfigurerAdapter，实现public void addInterceptors(InterceptorRegistry registry)方法来添加拦截器。
3.注意拦截器的规则：
类似包围圈，比如有两个拦截器interceptorOne和interceptorTwo，one在前two在后，则request是one->two->controller,
response则相反：controller->two->one。
