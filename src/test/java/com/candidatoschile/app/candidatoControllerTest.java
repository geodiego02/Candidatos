package com.candidatoschile.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.candidatoschile.app.service.candidatoService;
import com.candidatoschile.app.controller.candidatoController;
import com.candidatoschile.app.entity.candidato;

@ExtendWith(SpringExtension.class)
@WebMvcTest(candidatoController.class)
public class candidatoControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private candidatoService candidatoService;

    //lista candidatos a ser probados
    private List<candidato> expectedCandidates;
    
    @BeforeEach
    public void setUp() {
        // Create a list of candidates
        expectedCandidates = new ArrayList<>();
        expectedCandidates.add(new candidato(1L, "juan.perez@email.com", "Juan", "Perez"));
        expectedCandidates.add(new candidato(2L, "maria.lopez@email.com", "Maria", "Lopez"));
        // ... other candidates

        // Mock the service layer
        Mockito.when(candidatoService.findAll(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(expectedCandidates));
    }
    @Test
    public void readAll_ShouldReturnPageOfCandidates() throws Exception {
        mockMvc.perform(get("/api/candidatos")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(expectedCandidates.size()));
    }
    
}
