/**
 * Created by 10064028 on 2018/1/30.
 */

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rj.domain.User;
import com.rj.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml"})
public class TestWrapper {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("阮金");
        user.setAge(1);
        user.setAge(18);
        user.setSchoolName("cug");
        userService.insert(user);
    }

    @Test
    public void testSelect(){
        //EntityWrapper<User> wrapper = new EntityWrapper<>();
        //wrapper.setEntity(new User());
        Wrapper<User> wrapper = new Wrapper<User>() {
            @Override
            public String getSqlSegment() {
                return "where id > 7 and gender = 1 and age >10 and school_name = 'cug'";
            }
        };
        User user = userService.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testList(){
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new User());
        wrapper.where(true, "id>1");
        wrapper.and("id<{0}", 10);
        wrapper.andNew();
        wrapper.where("gender={0}", 1);
        wrapper.or("gender={0}", 0);
        userService.selectList(wrapper);
        Page<Map<String, Object>> mapPage = userService.selectMapsPage(new Page(1, 5), wrapper);
        List<Map<String, Object>> records = mapPage.getRecords();
        Map<String, Object> stringObjectMap = records.get(0);
        for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println("================================================================================");
        userService.selectPage(new Page<>(2, 5));
    }
}
