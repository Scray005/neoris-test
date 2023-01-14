package com.test.neoris.neoristest.testControllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class MovimientosController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void ServiceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movimientos/findAll")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void ServiceFindTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movimientos/find/2")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @ParameterizedTest
    @MethodSource("requestsValidateService")
    void saveMovimientoTest(String req) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        String request = Files.lines(Paths.get(Objects.requireNonNull(loader.getResource(req)).toURI())).parallel()
                .collect(Collectors.joining());

        mockMvc.perform(MockMvcRequestBuilders.post("/movimientos/create").contentType(MediaType.APPLICATION_JSON)
                .content(request).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private static Stream<Arguments> requestsValidateService() {
        return Stream.of(Arguments.arguments("payload/findall-movimiento-debito-response.json", null),
                Arguments.arguments("payload/findall-movimiento-credito-response.json", null));
    }
}
