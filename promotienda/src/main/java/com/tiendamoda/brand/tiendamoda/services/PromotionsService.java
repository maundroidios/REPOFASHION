package com.tiendamoda.brand.tiendamoda.services;

import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;

import java.util.Date;
import java.util.List;


public interface PromotionsService {

    List<Promotion> getPromotions();


    Promotion getPromotionById(Long id);


    PromotionDTO getPromotionByBrandProductDate(Long brandId, Long productId, Date date);

}
