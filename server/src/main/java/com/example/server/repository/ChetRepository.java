package com.example.server.repository;

import com.example.server.entity.Chet;
import com.example.server.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChetRepository extends JpaRepository<Chet, Integer> {

    List<Chet> findByIdIn(List<Integer> ids);
}
