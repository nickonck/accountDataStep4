package es.unileon.ulebank.springapp.service;

import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NewOverdraft {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Min(0)
	private double value;
	
	public void setValue(double value){
		this.value=value;
		logger.info("Value set to " + value);
	}
	
	public double getValue(){
		return value;
	}
}
