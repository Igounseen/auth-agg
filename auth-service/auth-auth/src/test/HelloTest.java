import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HelloTest {

    @Test
    public void f1(){
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
