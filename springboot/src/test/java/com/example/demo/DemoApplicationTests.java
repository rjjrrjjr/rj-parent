package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private UserService userService;

	protected MockMvc mockMvc;

	@Before
	public void setUp(){
		System.out.println("-----------------------setUp-------------------------");
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testOne() throws Exception {
		System.out.println("-------------------------start--------------------------------");
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/index").param("1", "1").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
		System.out.println(mvcResult.getResponse().getStatus());
		System.out.println(mvcResult.getResponse().getContentAsString());
		System.out.println("-------------------------end--------------------------------");
	}

	@Test
	public void testTwo(){
		System.out.println(userService.select());
	}

	@Test
	public void testThree(){
		System.out.println("=================================");
	}

}
