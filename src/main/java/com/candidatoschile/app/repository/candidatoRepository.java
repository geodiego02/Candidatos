package com.candidatoschile.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidatoschile.app.entity.candidato;

@Repository
public interface candidatoRepository extends JpaRepository<candidato,Long>{

}
