package com.example.demo.rabat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabatRepository extends JpaRepository<Rabat, Long> {
    Rabat findByProcentRabatu(Float procentRabatu);
}
