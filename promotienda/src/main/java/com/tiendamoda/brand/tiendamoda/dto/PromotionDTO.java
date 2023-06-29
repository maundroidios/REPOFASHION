package com.tiendamoda.brand.tiendamoda.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PromotionDTO {

    Long productId;
    Long brandId;
    Long fee;
    Date startDateTime;
    Integer priority;
    Date endDateTime;
    Double finalPrice;

}
