import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-06-22
 */
@RestController
@EnableAutoConfiguration
public class Application {

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
