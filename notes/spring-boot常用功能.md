## 事件机制
事件继承ApplicationEvent，
订阅者实现ApplicationListener<Event>
发布者使用applicationContext.publishEvent(event)发布事件。
## 异步与多线程支持
@Async&@EnableAsync注解来支持异步和多线程，实现 AsyncConfigurer 接口来配置ThreadPoolTaskExecutor。
## 计划任务
使用@Scheduled实现计划任务，具体设置见此注解参数。@EnableScheduling开启计划任务。