package com.clusus;


import com.clusus.controller.MainController;
import com.clusus.entity.Deal;
import com.clusus.service.DealService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MainController.class)
@WithMockUser
public class MainControllerTest {


    String dealJson="{\n" +
            "    \"id\":12453,\n" +
            "    \"fromCurrencyIsoCode\":\"NPR\",\n" +
            "    \"toCurrencyIsoCode\":\"NPR\",\n" +
            "    \"dealTime\":\"2022-08-18 22:31:13\",\n" +
            "    \"amount\":45.44\n" +
            "}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealService dealService;

    public MainControllerTest() throws ParseException {
    }

    @Test
    public void saveDealDetails() throws Exception {
        Mockito.when(dealService.saveDeal(Mockito.any(Deal.class),
                Mockito.anyList())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/deal")
                .accept(MediaType.APPLICATION_JSON).content(dealJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        String expected ="{\n" +
                "    \"status\": 200,\n" +
                "    \"message\": [\n" +
                "        \"Saved Successfully\"\n" +
                "    ]\n" +
                "}";
        JSONAssert.assertEquals(expected,response.getContentAsString(),false);
    }

}
