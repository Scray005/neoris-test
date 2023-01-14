package com.test.neoris.neoristest.testControllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ClienteController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void ServiceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes/findAll")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void ServiceFindTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes/find/2")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
