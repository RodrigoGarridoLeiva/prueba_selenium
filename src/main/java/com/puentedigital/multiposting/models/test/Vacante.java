package com.puentedigital.multiposting.models.test;

import javax.persistence.*;

@Entity
@Table(name = "vacante")
public class Vacante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column(nullable = false)
	private int company_id;
	
	@Column(nullable = false)
	private int job_description;
	
	@Column(nullable = false)
	private int hr_add_id;
	
	@Column(nullable = false)
	private int god_add_id;
	
	@Column(nullable = false)
	private int lab_add_id;
	
	@Column(nullable = false)
	private int id_status;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getJob_description() {
		return job_description;
	}

	public void setJob_description(int job_description) {
		this.job_description = job_description;
	}

	public int getHr_add_id() {
		return hr_add_id;
	}

	public void setHr_add_id(int hr_add_id) {
		this.hr_add_id = hr_add_id;
	}

	public int getGod_add_id() {
		return god_add_id;
	}

	public void setGod_add_id(int god_add_id) {
		this.god_add_id = god_add_id;
	}

	public int getLab_add_id() {
		return lab_add_id;
	}

	public void setLab_add_id(int lab_add_id) {
		this.lab_add_id = lab_add_id;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	

}
