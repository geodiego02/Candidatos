package com.candidatoschile.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.candidatoschile.app.entity.candidato;

public interface candidatoService {

	public Iterable<candidato> findAll();
	public Page<candidato> findAll(Pageable pageable);
	//aquí llegué
}
