package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MainController mainController;

    Product product1 = new Product(1L, "Meat", 1000);
    Product product2 = new Product(2L, "Fish", 900);

    @Test
    void getProducts() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(product1, product2));
        Mockito.when(mainController.getProducts()).thenReturn(records);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/getProducts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].productName", Matchers.is("Meat")))
                .andExpect(jsonPath("$[1].productName", Matchers.is("Fish")));
    }

    @Test
    void postProduct() {
    }

    @Test
    void getDiscount() {
    }

    @Test
    void getSales() {
    }

    @Test
    void postSales() {
    }

    @Test
    void getHourlyStatistics() {
    }
}