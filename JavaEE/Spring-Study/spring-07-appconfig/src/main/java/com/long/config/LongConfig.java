import org.springframework.context.annotation.Configuration;

@Configuration
public class LongConfig {
    public User getUser(){
        return new User();
    }
}
