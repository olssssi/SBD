package com.example.demo.stanowisko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StanowiskoRepository extends JpaRepository<Stanowisko, Long> {
}
