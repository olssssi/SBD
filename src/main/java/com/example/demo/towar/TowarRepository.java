package com.example.demo.towar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowarRepository extends JpaRepository<Towar, Long> {
}