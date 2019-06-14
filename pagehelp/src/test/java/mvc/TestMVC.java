package mvc;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rj.controller.UserController;

/**
 * Created by 10064028 on 2018/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml", "classpath:servlet-context.xml"})
@WebAppConfiguration
public class TestMVC {

    @Autowired
    private UserController userController;
    //protected WebApplicationContext wac;

    @Autowired
    private Date date;

    protected MockMvc mockMvc;

    @Before
    public void setUp(){
        System.out.println("===========public void setUp(){================");
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testSelect() throws Exception {
        System.out.println("---------------------begin-----------------------");
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/user/list").accept(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                //.andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("user"))
                //.andExpect(MockMvcResultMatchers.view().name("user/view"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletRequest request = mvcResult.getRequest();

        System.out.println(request.getRequestURL().toString());
        //request.setLocalPort(8080);
        System.out.println(request.toString());
        MockHttpServletResponse response = mvcResult.getResponse();
        System.out.println("err:" + response.getErrorMessage());
        System.out.println(response.getContentAsString());
        System.out.println("---------------------end-----------------------");
    }

    @Test
    public void select() throws Exception {
        System.out.println("-------------------------start");
        System.out.println(date);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/select").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
        System.out.println(mvcResult.getRequest().getRequestURL().toString());
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getContentAsString());
        System.out.println("------------------------end");
    }
}
