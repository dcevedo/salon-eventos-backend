package com.ciclo3.saloneventos;

import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
// import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;

@RunWith(SpringRunner.class)
@SpringBootTest
// @WebMvcTest(TestController.class)
@AutoConfigureMockMvc
public class TestControllerTestDAO {
    @MockBean
    private ReservationService reservationService;
    
    @Autowired
    private MockMvc mockMvc;

    // @Autowired
    // private ObjectMapper objectMapper;

    @Test
    public void shouldReturnDTO() throws Exception {
        long id = 2L;
        // Score score = new Score(5);
        Reservation reservation = new Reservation(id,Date.valueOf(LocalDate.of(2021, 6, 3)),   Date.valueOf(LocalDate.of(2021, 6, 4)),"");
        when(reservationService.getById(id)).thenReturn(reservation);
        mockMvc.perform( MockMvcRequestBuilders
            .get("/api/test/{id}",id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            // .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
            .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value(reservation.getStartDate().toString()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.devolutionDate").value(reservation.getDevolutionDate().toString()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(reservation.getStatus().toString()))
            .andDo(MockMvcResultHandlers.print());

    }
}
