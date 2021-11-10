package com.puentedigital.multiposting.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puentedigital.multiposting.dao.repositories.VacancyRepository;
import com.puentedigital.multiposting.models.test.Vacante;

@Service
public class VacancyServices {

	@Autowired
	VacancyRepository vacanteRepository;
	
	public ArrayList<Vacante> obtenerVacantes(){
		
		return (ArrayList<Vacante>) vacanteRepository.findAll();
		
	}
	
	public Vacante guardarVacante(Vacante vacante) {
		
		//Guardar datos del job_description
		//vacante.setJob_description(1); Id del job_description
		
		System.out.println(vacante.getCompany_id());
		
		
		return vacanteRepository.save(vacante);
	}
	
	
}
