package com.example.online_shopping.deliveries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
    Optional<Delivery>findByIdAndDeletedAtIsNull(Integer id);
}
