import com.alibaba.fastjson.JSONObject;
import com.swx.auth.auth.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
public class HelloTest {

    @Test
    public void f1() {
        System.out.println(BCrypt.hashpw(
                "111111", BCrypt.gensalt()));
    }

    @Test
    public void f2() {
        System.out.println(new Date(1574236116000L));
    }

    @Test
    public void f3(){
        UserDto user = new UserDto(1L,"swx","asdf");
        System.out.println(JSONObject.toJSONString(user));
    }
}
