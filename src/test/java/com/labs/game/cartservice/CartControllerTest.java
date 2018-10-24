package com.labs.game.cartservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getItems_returnsOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cart-items?customer=111")) // calling mocked MVC Controller
                .andExpect(status().isOk()); //asserting that it responds with HTTP 200 status code

    }

    @Test
    public void getItems_returnsCustomer() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/cart-items?customer=111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customer").value("111")); // customer code should correspond to the requested value

        mockMvc.perform(MockMvcRequestBuilders.get("/cart-items?customer=222"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customer").value("222")); // the same should happen for a different customer code

    }

    @Test
    public void getItems_returnsEmptyList_forUnknownCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cart-items?customer=333"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0))); // empty list should be returned for unknown customer

    }
}