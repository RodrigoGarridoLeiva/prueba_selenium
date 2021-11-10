package com.puentedigital.multiposting.models.test;

import javax.persistence.*;

@Entity
@Table(name = "job_description")
public class JobDescription {

	//Pocos campos para pruebas de llenado de BD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String job_title;
	
	@Column(nullable = false)
	private long sueldo_liquido;
	
	@Column(nullable = false)
	private int modality_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public long getSueldo_liquido() {
		return sueldo_liquido;
	}

	public void setSueldo_liquido(long sueldo_liquido) {
		this.sueldo_liquido = sueldo_liquido;
	}

	public int getModality_id() {
		return modality_id;
	}

	public void setModality_id(int modality_id) {
		this.modality_id = modality_id;
	}
	
}
