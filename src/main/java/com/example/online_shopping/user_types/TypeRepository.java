package com.example.online_shopping.user_types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Optional<Type> findByIdAndDeletedAtIsNull(Integer id);
}
