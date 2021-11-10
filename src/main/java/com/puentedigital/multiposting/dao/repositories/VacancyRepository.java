package com.puentedigital.multiposting.dao.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puentedigital.multiposting.models.test.Vacante;

@Repository
public interface VacancyRepository extends CrudRepository<Vacante, Long> {

	ArrayList<Vacante> findAll();
	
	

}
