package com.login.loginpage;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.login.loginpage.controller.model.User;
import com.login.loginpage.exception.UserServiceException;
import com.login.loginpage.repository.UserRepository;
import com.login.loginpage.services.UserService;
import com.login.loginpage.services.UserServiceImpl;

public class TestUser {
    
	private static final int id = 2;
	private User user;
	private MockMvc mockMvc;
	private List<User> users;
	
	@InjectMocks
	private UserServiceImpl userserviceImpl = new UserServiceImpl();
	
	
	
	@Mock 
	private UserRepository userRepository;
	
	@Before
	public void setUp() {

		this.user = Mockito.mock(User.class);
		this.users = Arrays.asList(user);
	    Mockito.doReturn(id).when(this.user).getId();
	     mockMvc = MockMvcBuilders.standaloneSetup()
                .build();
		MockitoAnnotations.initMocks(this);
		
	}
	@Test
	public void testgetAllUser() throws UserServiceException {
		when(userRepository.findAll()).thenReturn(users);
        List<User> actualUsers = userserviceImpl.getAllUsers();
		assertEquals(user,actualUsers.get(0));
		 verify(userRepository).findAll();
       }
	
	@Test
     public void testgetUser() throws UserServiceException {
 
         when(userRepository.findById(user.getId())).thenReturn(user);
         //why you  making Initialize with object
 		 Object actualUser = userserviceImpl.getUser(id);
          assertEquals(user,actualUser);
   }
	

	
	@Test
	public void testaddUser() throws UserServiceException{
		//user = new User(101, "VASUDHA","NIKHITHA","HARIKA","VNH@email.com","querty");
		//System.out.println("username:" +user.getUsername());
		//userservice.addUser(user);
		when(userRepository.save(user)).thenReturn(user);
		Object actualUsers = userserviceImpl.addUser(user);
		assertEquals(user, actualUsers);
		verify(userRepository).save(user);
		
	}
	
	@Test
	public void testupdateUser() throws UserServiceException {
		when(userRepository.save(user)).thenReturn(user);
		//when(userRepository.findById()).thenReturn(userRepository.findById());
		Object actualUsers = userserviceImpl.updateUser(null, user);
		assertEquals(user, actualUsers);
		verify(userRepository).save(user);
		
	}
 


	@Test
    public void testPost() throws UserServiceException {
        String json =  "{\n" +
                "  \"id\": \"2\"\n" +
                "  \"username\": \"Nikhi\"\n" +
                "  \"firstname\": \"Manoj\"\n" +
                "  \"lastname\": \"Pannala\"\n" +
                "  \"password\": \"Manu1\"\n" +
                "  \"Email\": \"Mp@gmail.com\"\n" +
               
                "}";
        try {
			mockMvc.perform(post("/users/{username}")
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}