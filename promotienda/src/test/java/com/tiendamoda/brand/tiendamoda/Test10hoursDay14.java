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
 class Test10hoursDay14 {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
     void promotionTest10hoursDay14() throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dateStart = simpleDateFormat.parse("2020-06-14 00:00:00");
        Date dateEnd = simpleDateFormat.parse("2020-12-31 23:59:59");

        PromotionDTO promoTest = new PromotionDTO();
        promoTest.setStartDateTime(dateStart);
        promoTest.setProductId(35455L);
        promoTest.setBrandId(1L);
        promoTest.setFee(1L);
        promoTest.setPriority(0);
        promoTest.setEndDateTime(dateEnd);
        promoTest.setFinalPrice(35.50D);

        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/api/promotion/customadvance/1/35455/2020-06-14@10:00:00",
                PromotionDTO.class)).isEqualTo(promoTest);
    }

}
