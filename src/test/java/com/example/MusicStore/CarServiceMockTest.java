package com.example.MusicStore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarServiceMockTest {

    @Mock
    private InstrumentRepo instrumentRepo;

    @InjectMocks
    private InstrumentService instrumentService;

//    @Test
//    public void testRetrieveInstrumentMockRepo() throws Exception {
//        Instrument instrument = new Instrument(1L, "test", "test", "test", "test", 4444);
//        instrument.setInstId(1L);
//        Mockito.when(instrumentRepo.findById(1l)).thenReturn(Optional.of(instrument));
//        Assert.isTrue(instrumentService.findById(1L).getBrand().equalsIgnoreCase("test"));
//    }

//    @Test
//    public void whenInstrumentIdProvided_thenNameCorrect() {
//        Mockito.when(instrumentService.getInstrumentBrand(1L)).thenReturn("Brand name");
//        String testBrand = instrumentService.getInstrumentBrand(1l);
//        Assert.assertEquals("Brand name", testBrand);
//    }


//    @Test
//    void isCreateOk() throws Exception {
//        mockMvc.perform(get("/main/create"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"instId\":1,\"instType\":\"Guitar\"," +
//                        "\"subType\":\"Acoustic\",\"brand\":\"Guild\",\"model\":\"ACE99\",\"price\":4999}"));
//    }


}
