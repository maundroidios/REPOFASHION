package com.tiendamoda.brand.tiendamoda.repository;

import com.tiendamoda.brand.tiendamoda.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
