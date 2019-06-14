import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rj.model.UserEntity;
import com.rj.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 10064028 on 2018/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml"})
@Slf4j
public class TestTK {

    @Autowired
    private UserService userService;

    @Test
    public void testID(){
        log.info("==================================begin=================");
        UserEntity userEntity = userService.save();
        System.out.println(userEntity.getId());
    }
}
