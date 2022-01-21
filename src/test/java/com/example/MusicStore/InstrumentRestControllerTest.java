package com.example.MusicStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class InstrumentRestControllerTest {

//    @LocalServerPort
//    private int port;

//    TestRestTemplate restTemplate = new TestRestTemplate();
//    HttpHeaders headers = new HttpHeaders();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldPrintWelcome() throws Exception {
        mockMvc.perform(get("/main"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to the Music Store!"));

    }

    @Test
    void isCreateOk() throws Exception {
        mockMvc.perform(get("/main/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"instId\":1,\"instType\":\"Guitar\"," +
                        "\"subType\":\"Acoustic\",\"brand\":\"Guild\",\"model\":\"ACE99\",\"price\":4999}"));
    }


    @Test
    void shouldFindInst10() throws Exception{
        mockMvc.perform(get("/main/find/10"))
                .andDo(print())
                .andExpect(status().isOk());
    }


//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }

    private String createSampleJsonData() {
        return "{\"instId\":99,\"instType\":\"testType\",\"subType\":\"testSubtype\",\" +\n" +
                "                        \"brand\":\"testBrand\",\"model\":\"testModel\",\"price\":9999}";
    }

}
