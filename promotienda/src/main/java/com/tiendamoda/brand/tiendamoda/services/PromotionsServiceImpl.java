package com.tiendamoda.brand.tiendamoda.services;


import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;
import com.tiendamoda.brand.tiendamoda.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PromotionsServiceImpl implements PromotionsService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotionById(Long id) {
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        return optionalPromotion.orElse(null);
    }

    @Override
    public PromotionDTO getPromotionByBrandProductDate(Long idBrand, Long productId, Date date) {
        Promotion promotion = new Promotion();
        promotion.setIdBrand(idBrand);
        promotion.setProductId(productId);
        List<Promotion> results = promotionRepository.findAll(Example.of(promotion));
        return calculateFee(calculateRangeDateTime(results, date));

    }

    private List<Promotion> calculateRangeDateTime(List<Promotion> results, Date date) {

        List<Promotion> resultFiltered = new ArrayList<Promotion>();
        results.forEach(promotion -> {
            if (date.after(promotion.getStartDateTime()) && date.before(promotion.getEndDateTime())) {
                resultFiltered.add(promotion);
            }
        });
        return resultFiltered;
    }


    private PromotionDTO calculateFee(List<Promotion> results) {
        List<PromotionDTO> promotionDTOs = results.stream().map(promotion -> {
            PromotionDTO dto = new PromotionDTO();
            dto.setProductId(promotion.getProductId());
            dto.setBrandId(promotion.getIdBrand());
            dto.setStartDateTime(promotion.getStartDateTime());
            dto.setPriority(promotion.getPriority());
            dto.setEndDateTime(promotion.getEndDateTime());
            dto.setFee(promotion.getPriceList());
            dto.setFinalPrice(promotion.getPrice());
            return dto;
        }).toList();

        Optional<PromotionDTO> promotionDTO = Optional.empty();
        if (!promotionDTOs.isEmpty()) {
            promotionDTO = promotionDTOs.stream()
                    .max(Comparator
                            .comparingInt(PromotionDTO::getPriority));
        }

        return promotionDTO.orElse(null);
    }

}

