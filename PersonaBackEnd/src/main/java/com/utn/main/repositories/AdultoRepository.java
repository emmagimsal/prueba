package com.utn.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.main.entities.Adulto;
@Repository()
public interface AdultoRepository extends JpaRepository<Adulto, Integer>{

}
