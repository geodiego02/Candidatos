package com.candidatoschile.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidatoschile.app.entity.candidato;
import com.candidatoschile.app.repository.candidatoRepository;

@Service
public class candidatoServiceImpl implements candidatoService{

	@Autowired
	private candidatoRepository candidatoRepository;
	
	@Override
	@Transactional(readOnly =true)
	public Iterable<candidato> findAll() {
		
		return candidatoRepository.findAll();
	}

	@Override
	@Transactional(readOnly =true)
	public Page<candidato> findAll(Pageable pageable) {
		
		return candidatoRepository.findAll(pageable);
	}

}
