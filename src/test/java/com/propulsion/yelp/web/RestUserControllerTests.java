package com.propulsion.yelp.web;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc(print = MockMvcPrint.SYSTEM_ERR)
@Transactional
public class RestUserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository repository;

    @Test
    public void updateUser() throws Exception {

        String json = "{\"firstName\":\"Petra\",\"lastName\":\"Edited\",\"userId\":1}";

        mockMvc.perform( put( "/api/user/{id}", 1 ).contentType( APPLICATION_JSON ).content( json ) ).andExpect( status().isNoContent() );
    }

}
