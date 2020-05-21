package com.utn.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.main.entities.Auto;
@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

}
