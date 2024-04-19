package com.lb;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class DbControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testPostApi() throws Exception {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setUserName("Un");
//        userRequest.setPhNumber("212e32");
//        userRequest.setEmail("email");
//        userRequest.setPassword("123");
//
//
//        String jsonRequest = objectMapper.writeValueAsString(userRequest);
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/saveUser")
//                .contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
//                .andReturn();
//        String jsonResponse = mvcResult.getResponse().getContentAsString();
//
////                .andExpect(MockMvcResultMatchers.status().isOk());
////                .andExpect(MockMvcResultMatchers.content().string("Hello, welcome to the test!"));
//    }
}
