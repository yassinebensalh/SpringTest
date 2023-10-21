import com.example.stationski.controllers.MoniteurRestController;
import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.IMoniteurService;
import com.example.stationski.services.MoniteurServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MoniteurControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private IMoniteurService moniteurService;

    @Mock
    private MoniteurRepository moniteurRepository;

    @InjectMocks
    private MoniteurServiceImpl moniteurServiceImpl;

    @InjectMocks
    private MoniteurRestController moniteurRestController;

    Moniteur m = Moniteur.builder().idMoniteur(1).numMoniteur(1L).nomM("yassine").prenomM("ben Salha").dateRecru(LocalDate.of(2023,12,12)).prime(15f).build();
    List<Moniteur> records = new ArrayList<Moniteur>() {
        {
            add(Moniteur.builder().idMoniteur(1).numMoniteur(1L).nomM("yassine").prenomM("ben Salha").dateRecru(LocalDate.of(2023,12,12)).prime(15f).build());
            add(Moniteur.builder().idMoniteur(2).numMoniteur(2L).nomM("aziz").prenomM("nahdi").dateRecru(LocalDate.of(2022,12,12)).prime(10f).build());
            add(Moniteur.builder().idMoniteur(3).numMoniteur(3L).nomM("amine").prenomM("thabet").dateRecru(LocalDate.of(2021,12,12)).prime(5f).build());
        }
    };
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(moniteurRestController).build();
    }

    @Test
    public void GetAllRecords_success() throws Exception {

        Mockito.when(moniteurService.retrieveAllMoniteurs()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/moniteur/retrieve-all-moniteurs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$" , hasSize(3)))
                .andExpect(jsonPath("$[2].nomM" , is("amine")));
    }

    @Test
    public void retrieveMonitorsTest() {
        Mockito.when(moniteurRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(m));
        Moniteur moniteur = moniteurServiceImpl.retrieveMoniteur((int) 1);
        Assert.assertNotNull(moniteur);
        log.info("get ===> " + moniteur.toString());
        Mockito.verify(moniteurRepository).findById(Mockito.anyInt());
    }
}
