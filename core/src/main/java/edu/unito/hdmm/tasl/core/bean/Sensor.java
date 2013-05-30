package edu.unito.hdmm.tasl.core.bean;

import edu.unito.hdmm.tasl.core.geo.TempPoint;

public class Sensor {

	
	
	private TASLObject id;
	private TempPoint tempPoint;
	
	
	public Sensor(TASLObject id, TempPoint tempPoint) {
		super();
		this.id = id;
		this.tempPoint = tempPoint;
	}


	public TASLObject getId() {
		return id;
	}


	public TempPoint getTempPoint() {
		return tempPoint;
	}
	
	
	
	
	
	
	
	
}
