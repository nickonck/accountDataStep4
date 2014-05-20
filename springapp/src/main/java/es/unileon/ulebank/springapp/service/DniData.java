package es.unileon.ulebank.springapp.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DniData {


	protected final Log logger = LogFactory.getLog(getClass());

	@NotNull
	@Size (min=9, max=9)
	private String dni;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
