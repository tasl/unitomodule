package edu.unito.hdmm.tasl.core.bean;

import java.util.Date;

public class TASLValue {

	public double value;
	public Date timestamp;
	
	
	
	public TASLValue(double value, Date timestamp) {
		super();
		this.value = value;
		this.timestamp = timestamp;
	}
	
	public double getValue() {
		return value;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	
    
	

	
	
	
	
}
