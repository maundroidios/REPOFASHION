package com.tiendamoda.brand.tiendamoda.controllers;

import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;
import com.tiendamoda.brand.tiendamoda.services.PromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PromotionsController {

    @Autowired
    private PromotionsService promotionsService;

    @GetMapping("/api/promotion/{id}")
    public Promotion getPromotionById(@PathVariable Long id) {
        return promotionsService.getPromotionById(id);
    }

    @GetMapping("/api/promotions")
    public List<Promotion> getPromotions() {
        return promotionsService.getPromotions();
    }

    @GetMapping("/api/promotion/customadvance/{brandId}/{productId}/{date}")
    public PromotionDTO getPromotionByBrandProductDate(@PathVariable("brandId") Long brandId,
                                                       @PathVariable("productId") Long productId,
                                                       @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd@HH:mm:ss") Date date) {
        return promotionsService.getPromotionByBrandProductDate(brandId, productId, date);
    }


}
