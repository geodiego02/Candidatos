package com.candidatoschile.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidatoschile.app.entity.candidato;
import com.candidatoschile.app.service.candidatoService;

@RestController
@RequestMapping("/api/candidatos")
public class candidatoController {

	@Autowired
	private candidatoService candidatoService;
	
	@GetMapping
	public Page<candidato> readAll(Pageable pageable) {
		
		return candidatoService.findAll(pageable);
		
	}
}
