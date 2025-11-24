package org.example.jpaonetomanye24a.mocking;

import org.example.jpaonetomanye24a.model.Kommune;
import org.example.jpaonetomanye24a.repositories.KommuneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MockKommuneRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    // ✅ Only the repository is mocked
    @MockBean
    private KommuneRepository kommuneRepository;

    @Test
    void getKommunerStartsWith_returnsList() throws Exception {

        // Arrange
        List<Kommune> mockList = List.of(
                new Kommune("0001", "Aarhus"),
                new Kommune("0002", "Aalborg"),
                new Kommune("0003", "Roskilde"),
                new Kommune("0004","Herning"),
                new Kommune("0005", "Horsens")
        );

        when(kommuneRepository.findAll()).thenReturn(mockList);

        // Act + Assert
        mockMvc.perform(get("/kommunestart/A")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].navn").value("Aarhus"))
                .andExpect(jsonPath("$[1].navn").value("Aalborg"));

        // Verify repository was called exactly once
        verify(kommuneRepository).findAll();
    }
}