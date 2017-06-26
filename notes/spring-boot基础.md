## spring-boot 基础
## 注解
### @SpringBootApplication
加在application上，会自动扫描目录下、子目录下所有组件
### @Controller、@RestController
@RestController相当于在@Controller+@@ResponseBody。
### @PropertySource、@ConfigurationProperties
这两个注解用于加载配置文件
@PropertySource指定文件地址：
@PropertySource("classpath:config/book.properties")
@ConfigurationProperties指定前缀：
@ConfigurationProperties(prefix = "book")
## 加载配置文件
### properties文件
1. 定义配置文件：
config/book.properties:
```
book.name = 算法导论
book.version = 3
book.author = CLRS
book.desc = ${book.name}(原版第${book.version}版)-${book.author}

```
2. 定义配置类
```
@Component
@PropertySource("classpath:config/book.properties")
@ConfigurationProperties(prefix = "book")
public class BookProperties {
    private String name;
    private String version;
    private String author;
    private String desc;

    //getter、setter...
}
```
根据配置类定义的前缀和字段名，会与配置文件中匹配的字段完成注入。
***目前@PropertySource不支持自定义的yaml文件。***
### 多环境下配置的选择
不同环境的配置文件需要满足application-{profile}.properties的格式。
然后在application.properties中配置`spring.profiles.active={profile}`即可启用对应配置。