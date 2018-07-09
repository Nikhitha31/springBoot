package com.login.loginpage;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.login.loginpage.controller.Restcontroller;
import com.login.loginpage.exception.UserServiceException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,		
classes =  Loginpage1Application.class		
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:applicationdb.properties")
public class Loginpage1ApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	private Restcontroller restcontroller;
	
	@Before
	public void setUp() {		
     mockMvc = MockMvcBuilders.standaloneSetup(restcontroller)
               .build();
		
}

    @Test
    public void testPut() throws UserServiceException {
		String json = "{\"id\": 2,"
				+ "\"username\": \"Nikhi\","
				+ "\"firstname\": \"Manoj\","
				+ "\"lastname\": \"Pannala\","
				+ "\"password\": \"Manu1\","
				+ "\"Email\": \"Mp@gmail.com\"}";
       try {
			mockMvc.perform(put("/users/{username}")
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(json))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.id", Matchers.is("id")))
			        .andExpect(jsonPath("$.username", Matchers.is("Nikhi")))
			        .andExpect(jsonPath("$.firstnsme", Matchers.is("Manoj")))
			        .andExpect(jsonPath("$.lastname", Matchers.is("Pannala")))
			        .andExpect(jsonPath("$.Email", Matchers.is("Mp@gmail.com")))
			        .andExpect(jsonPath("$.password", Matchers.is("Manu1")))
			        .andExpect(jsonPath("$.*", Matchers.hasSize(6)));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Test
    public void testGetUserById() throws UserServiceException {
//		String json = "{\"id\": 2,"
//				+ "\"username\": \"Nikhi\","
//				+ "\"firstname\": \"Manoj\","
//				+ "\"lastname\": \"Pannala\","
//				+ "\"password\": \"Manu1\","
//				+ "\"Email\": \"Mp@gmail.com\"}";
       try {
			mockMvc.perform(get("/users/{id}")
			        .contentType(MediaType.APPLICATION_JSON))
			        //.content(json))
			        .andExpect(status().isOk());
//			        .andExpect(jsonPath("$.id", Matchers.is("2")))
//			        .andExpect(jsonPath("$.username", Matchers.is("Nikhi")))
//			        .andExpect(jsonPath("$.firstnsme", Matchers.is("Manoj")))
//			        .andExpect(jsonPath("$.lastname", Matchers.is("Pannala")))
//			        .andExpect(jsonPath("$.Email", Matchers.is("Mp@gmail.com")))
//			        .andExpect(jsonPath("$.password", Matchers.is("Manu1")))
//			        .andExpect(jsonPath("$.*", Matchers.hasSize(6)));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
    public void testDeleteUserById() throws UserServiceException {
//		String json = "{\"id\": 2,"
//		+ "\"username\": \"Nikhi\","
//		+ "\"firstname\": \"Manoj\","
//		+ "\"lastname\": \"Pannala\","
//		+ "\"password\": \"Manu1\","
//		+ "\"Email\": \"Mp@gmail.com\"}";
		
       try {
			 mockMvc.perform(delete("/users/{id}")
			        .contentType(MediaType.APPLICATION_JSON))
			       // .content(json))
			        .andExpect(status().isOk())
			        .andExpect(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void testGetAllUsers() throws UserServiceException {
//		
//		 String json = "{\"id\": 4,"
//			+ "\"username\": \"Nikhi\","
//			+ "\"firstname\": \"Manoj\","
//			+ "\"lastname\": \"Pannala\","
//			+ "\"password\": \"Manu1\","
//			+ "\"Email\": \"Mp@gmail.com\","
//			+ "\"id\": 3,"
//			+ "\"username\": \"Anjali\","
//			+ "\"firstname\": \"Anjali1\","
//			+ "\"lastname\": \"Kodimyala\","
//			+ "\"password\": \"anjali111\","
//			+ "\"Email\": \"Ak@gmail.com\","
//			+ "}";
       try {
    	   System.out.println("xyz:"+this.mockMvc.perform(get("/users")
			        .contentType(MediaType.APPLICATION_JSON))
			        //.content(json))
			        .andExpect(status().isOk()));
//			        .andExpect(jsonPath("$.id", Matchers.is("4")))
//			        .andExpect(jsonPath("$.username", Matchers.is("Nikhi")))
//			        .andExpect(jsonPath("$.firstnsme", Matchers.is("Manoj")))
//			        .andExpect(jsonPath("$.lastname", Matchers.is("Pannala")))
//			        .andExpect(jsonPath("$.Email", Matchers.is("Mp@gmail.com")))
//			        .andExpect(jsonPath("$.password", Matchers.is("Manu1")))
//			        .andExpect(jsonPath("$.id", Matchers.is("3")))
//			        .andExpect(jsonPath("$.username", Matchers.is("Anjali")))
//			        .andExpect(jsonPath("$.firstnsme", Matchers.is("Anjali1")))
//			        .andExpect(jsonPath("$.lastname", Matchers.is("kodimyala")))
//			        .andExpect(jsonPath("$.Email", Matchers.is("Ak@gmail.com")))
//			        .andExpect(jsonPath("$.password", Matchers.is("anjali111")))
//			        .andExpect(jsonPath("$.*", Matchers.hasSize(12)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void testPostUser() throws UserServiceException {
		String json = "{\"id\": 2,"
				+ "\"username\": \"Nikhi\","
				+ "\"firstname\": \"Manoj\","
				+ "\"lastname\": \"Pannala\","
				+ "\"password\": \"Manu1\","
				+ "\"Email\": \"Mp@gmail.com\"}";
       try {
    	   
			 mockMvc.perform(post("/users")
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(json))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.id", Matchers.is("2")))
			        .andExpect(jsonPath("$.username", Matchers.is("Nikhi")))
			        .andExpect(jsonPath("$.firstnsme", Matchers.is("Manoj")))
			        .andExpect(jsonPath("$.lastname", Matchers.is("Pannala")))
			        .andExpect(jsonPath("$.Email", Matchers.is("Mp@gmail.com")))
			        .andExpect(jsonPath("$.password", Matchers.is("Manu1")))
			        .andExpect(jsonPath("$.*", Matchers.hasSize(6)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
