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
public class Test16hoursDay14 {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void promotionTest16hoursDay14() throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dateStart = simpleDateFormat.parse("2020-06-14 15:00:00");
        Date dateEnd = simpleDateFormat.parse("2020-06-14 18:30:00");

        PromotionDTO promoTest = new PromotionDTO();
        promoTest.setStartDateTime(dateStart);
        promoTest.setProductId(35455L);
        promoTest.setBrandId(1L);
        promoTest.setFee(2L);
        promoTest.setPriority(1);
        promoTest.setEndDateTime(dateEnd);
        promoTest.setFinalPrice(25.45D);

        assertThat(this.restTemplate.getForObject("http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14@16:00:00",
                PromotionDTO.class)).isEqualTo(promoTest);


    }
}
