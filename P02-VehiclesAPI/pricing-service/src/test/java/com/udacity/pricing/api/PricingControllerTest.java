package com.udacity.pricing.api;


import com.udacity.pricing.entity.Price;
import com.udacity.pricing.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingControllerTest {

    protected Price retrievedPrice;
    protected BigDecimal expectedValue = new BigDecimal("900.99");

    @Autowired
    PriceRepository priceRepository;

    @Test
    public void testFindById() {
        retrievedPrice = priceRepository.findById(9L).get();
        BigDecimal actualPrice = retrievedPrice.getPrice();
        System.out.println("actualPrice: " + actualPrice);
        System.out.println("expectedValue: " + expectedValue);
        Assertions.assertEquals(actualPrice, expectedValue);
    }
}
