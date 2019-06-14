import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.rj.domain.UserEntity;
import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/1/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectById(){
        userService.selectByOneParam(2L);
    }

    @Test
    public void testRowBounds(){
        userService.listByRowBunds();
    }

    @Test
    public void testStartPage(){
        List<UserEntity> userEntities = userService.listByStartPage();
        System.out.println(((Page)userEntities).getTotal());
        System.out.println(((Page)userEntities).getPageSize());
        System.out.println(((Page)userEntities).getPageNum());
        System.out.println(((Page)userEntities).getPages());
        System.out.println(((Page)userEntities).getPageSizeZero());
        for (UserEntity userEntity : userEntities){
            System.out.println(userEntity.getName());
        }
    }

    @Test
    public void testStartPage2(){
        List<UserEntity> userEntities = userService.listByStartPage();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userEntities);
        System.out.println(pageInfo.getTotal());
        for (UserEntity userEntity : userEntities){
            System.out.println(userEntity.getName());
        }
    }

}
