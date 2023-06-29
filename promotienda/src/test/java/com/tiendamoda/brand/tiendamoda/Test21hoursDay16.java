package com.tiendamoda.brand.tiendamoda;

import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test21hoursDay16 {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void promotionTest21hoursDay16() throws Exception {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dateStart = simpleDateFormat.parse("2020-06-15 16:00:00");
        Date dateEnd = simpleDateFormat.parse("2020-12-31 23:59:59");

        PromotionDTO promoTest = new PromotionDTO();
        promoTest.setStartDateTime(dateStart);
        promoTest.setProductId(35455L);
        promoTest.setBrandId(1L);
        promoTest.setFee(4L);
        promoTest.setPriority(1);
        promoTest.setEndDateTime(dateEnd);
        promoTest.setFinalPrice(38.95D);

        assertThat(this.restTemplate.getForObject("http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-16@21:00:00",
                PromotionDTO.class)).isEqualTo(promoTest);
    }
}
