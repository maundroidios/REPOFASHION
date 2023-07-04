package com.tiendamoda.brand.tiendamoda;

import com.tiendamoda.brand.tiendamoda.model.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 class HttpRequestTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void promotionTest() throws Exception {
        Promotion promoTest = new Promotion();
        promoTest.getStartDate();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/promotions",
                List.class)).isNotNull();
    }



    @Test
     void promotionTest10hoursDay15() throws Exception {
        Promotion promoTest = new Promotion();
        promoTest.getStartDate();
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/promotion/customadvance/1/35455/2020-06-15T10",
                Promotion.class)).isNotNull();
    }
}
