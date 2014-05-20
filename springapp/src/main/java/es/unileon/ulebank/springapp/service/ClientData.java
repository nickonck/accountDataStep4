package es.unileon.ulebank.springapp.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientData {

	protected final Log logger = LogFactory.getLog(getClass());

	@NotNull
	@Size (min=9, max=9)
	private String dni;
	
	@NotNull
	@Size (min=2)
	private String name;
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
		logger.info("DNI: " + dni);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		logger.info("Name: " + name);
	}
}
