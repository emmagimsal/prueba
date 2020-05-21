package com.utn.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.main.entities.Niño;
@Repository()
public interface NiñoRepository extends JpaRepository<Niño, Integer> {

}
