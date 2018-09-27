package com.example.demo.controller;

import com.example.demo.service.HomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Here we're doing integration tests against a slice of the application (the web controller layer).
 * <p>
 * With annotation @WebMvcTest spring boot doesn't start all the application (e.g. no httpServer)
 * but only the web layer.
 *
 * Remaining dependencies required are replaced by Mock Objects.
 *
 * Using @WebMvcTest instead of SpringBootTest makes tests execution faster.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class) //this is replacing SpringBootTest
public class HomeControllerLightIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HomeService service;


    @Test
    public void test_root_should_return_helloworld() throws Exception {
        when(service.sayHello()).thenReturn("hello world");

        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"));

    }


}
