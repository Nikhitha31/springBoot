package com.login.loginpage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,		
classes =  Loginpage1Application.class		
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:applicationdb.properties")
public class IntegrationTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
	}


	@Test
	public void getUserById() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
	}
	
	@Test
	public void addUser() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
	}
	
	@Test
	public void PutUser() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/users/{username}").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
	}
}


