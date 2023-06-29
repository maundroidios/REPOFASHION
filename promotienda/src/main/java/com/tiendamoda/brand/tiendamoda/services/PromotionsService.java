package com.tiendamoda.brand.tiendamoda.services;

import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface PromotionsService {

    List<Promotion> getPromotions();


    Promotion getPromotionById(Long id);

    List<Promotion> getPromotionBySinse(Date sinse);
    List<Promotion> getPromotionByProductSinse(Long productId,Date sinse);

    PromotionDTO getPromotionByBrandProductSinse(Long brandId, Long productId, Date date);

}
