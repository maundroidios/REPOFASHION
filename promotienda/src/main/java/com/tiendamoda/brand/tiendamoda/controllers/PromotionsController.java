package com.tiendamoda.brand.tiendamoda.controllers;

import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;
import com.tiendamoda.brand.tiendamoda.services.PromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PromotionsController {

    @Autowired
    private PromotionsService promotionsService;

    @GetMapping("/api/promotions")
    public List<Promotion> getPromotions(){
        return promotionsService.getPromotions();
    }

    @GetMapping("/api/promotion/{id}")
    public Promotion getPromotionById(@PathVariable Long id){
        return promotionsService.getPromotionById(id);
    }


    @GetMapping("/api/promotion/custombasic/{productId}/{since}")
    public List<Promotion> getPromotionByProductSinse(@PathVariable("productId") Long productId,
                                               @PathVariable("since") @DateTimeFormat(pattern = "yyyy-MM-dd") Date since) {
        return promotionsService.getPromotionByProductSinse(productId,since);
    }

    @GetMapping("/api/promotion/customadvance/{brandId}/{productId}/{date}")
    public PromotionDTO getPromotionByBrandProductSinse(@PathVariable("brandId") Long brandId,
                                                        @PathVariable("productId") Long productId,
                                                        @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd@HH:mm:ss") Date date) {
        return promotionsService.getPromotionByBrandProductSinse(brandId,productId,date);
    }


}
