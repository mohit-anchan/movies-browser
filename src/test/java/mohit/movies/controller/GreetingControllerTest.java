package mohit.movies.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mohit on 11-May-19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerTest {

    @Autowired
    GreetingController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
     public void testGreeting_withUserName(){
        String userName = "Tom";
        assertEquals(controller.greeting(userName), "Hello "+userName);
    }

    /**
     * Calling an endpoint by URL and testing its response body
     * https://stackoverflow.com/a/18336481
     * https://stackoverflow.com/a/39268309
     * @throws Exception
     */
    @Test
    public void testGreeting_withNoUserName() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        MvcResult result = mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        assertEquals(responseBody, "Hello World");
    }
}
