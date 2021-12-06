package com.example.demo.producent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducentRepository extends JpaRepository<Producent, Long> {
}
