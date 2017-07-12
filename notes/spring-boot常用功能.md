## 事件机制
事件继承ApplicationEvent，
订阅者实现ApplicationListener<Event>
发布者使用applicationContext.publishEvent(event)发布事件。
## 异步与多线程支持
@Async&@EnableAsync注解来支持异步和多线程，实现 AsyncConfigurer 接口来配置ThreadPoolTaskExecutor。