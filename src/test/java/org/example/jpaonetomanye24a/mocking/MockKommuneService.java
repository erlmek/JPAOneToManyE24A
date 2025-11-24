package org.example.jpaonetomanye24a.mocking;

import org.example.jpaonetomanye24a.controller.KommuneRestController;
import org.example.jpaonetomanye24a.model.Kommune;
import org.example.jpaonetomanye24a.repositories.KommuneRepository;
import org.example.jpaonetomanye24a.service.ApiServiceGetKommuner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(KommuneRestController.class)
class MockKommuneService {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiServiceGetKommuner apiServiceGetKommuner;

    @MockBean
    private KommuneRepository kommuneRepository;

    @Test
    void getKommuneStartsWith_returnsList() throws Exception {

        // Arrange
        List<Kommune> mockList = List.of(
                new Kommune("0001", "Aarhus"),
                new Kommune("0002", "Aalborg")
        );

        when(apiServiceGetKommuner.getKommunerStartsWith('A')).thenReturn(mockList);

        // Act + Assert
        mockMvc.perform(get("/kommunestart/A")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].navn").value("Aarhus"))
                .andExpect(jsonPath("$[1].navn").value("Aalborg"));

        verify(apiServiceGetKommuner).getKommunerStartsWith('A');
    }
}