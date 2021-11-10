package com.puentedigital.multiposting.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puentedigital.multiposting.models.test.Vacante;
import com.puentedigital.multiposting.services.VacancyServices;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

	@Autowired
	VacancyServices vacanteService;
	
	@GetMapping()
	public ArrayList<Vacante> obtenerVacante(){
		
		return vacanteService.obtenerVacantes();
		
	}
	
	@PostMapping()
	public Vacante guardarVacante(@RequestBody Vacante vacante) {
		System.out.println("Controller");
		return this.vacanteService.guardarVacante(vacante);
		
	}
	
	
}
