## 事件机制
事件继承ApplicationEvent，
订阅者实现ApplicationListener<Event>
发布者使用applicationContext.publishEvent(event)发布事件。