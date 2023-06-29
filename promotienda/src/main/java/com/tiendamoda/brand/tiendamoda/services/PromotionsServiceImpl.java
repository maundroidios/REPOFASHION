package com.tiendamoda.brand.tiendamoda.services;


import com.tiendamoda.brand.tiendamoda.dto.PromotionDTO;
import com.tiendamoda.brand.tiendamoda.model.Promotion;
import com.tiendamoda.brand.tiendamoda.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
        return optionalPromotion.get();
    }

    public List<Promotion> getPromotionBySinse(Date date) {
        Promotion promo = new Promotion();
        promo.setStartDateTime(date);
        return promotionRepository.findAll(Example.of(promo));
    }

    @Override
    public List<Promotion> getPromotionByProductSinse(Long productId, Date date) {
        Promotion promotion = new Promotion();
        promotion.setProductId(productId);
        promotion.setStartDateTime(date);
        return promotionRepository.findAll(Example.of(promotion));
    }

    @Override
    public PromotionDTO getPromotionByBrandProductSinse(Long idBrand, Long productId, Date date) {
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
        List<PromotionDTO> promotionDTOlist = results.stream().map(promotion -> {
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

        Optional<PromotionDTO> promotionDTO = promotionDTOlist.stream()
                .max(Comparator
                        .comparingInt(PromotionDTO::getPriority));
        if (!promotionDTO.isEmpty())
            return promotionDTO.get();
        else
            return null;

    }

    private static String getDateWithoutTime(Date date) {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dt1.format(date);
        return dateString;
    }

}

