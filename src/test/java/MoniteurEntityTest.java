import com.example.stationski.entities.Moniteur;
import com.example.stationski.entities.MoniteurDTO;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.IMoniteurService;
import com.example.stationski.services.MoniteurServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@ExtendWith(MockitoExtension.class)
@WebMvcTest(Moniteur.class)
public class MoniteurEntityTest {

    private MockMvc mockMvc;

    @Mock
    private Moniteur moniteur;

    @Mock
    private MoniteurDTO moniteurDTO;

  //  Moniteur m = Moniteur.builder().idMoniteur(1).numMoniteur(1L).nomM("yassine").prenomM("ben Salha").dateRecru(LocalDate.of(2023,12,12)).prime(15f).build();
   // MoniteurDTO mDTO = MoniteurDTO.builder().numMoniteur(1L).nomM("yassine").prenomM("ben Salha").dateRecru(LocalDate.of(2023,12,12)).prime(15f).build();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(moniteur).build();

    }

    @Test
    public void moniteurSetterTest() {
        Moniteur moniteur = new Moniteur();
        moniteur.setNomM("yassine");
        Assertions.assertEquals("yassine" , moniteur.getNomM());
    }

}
