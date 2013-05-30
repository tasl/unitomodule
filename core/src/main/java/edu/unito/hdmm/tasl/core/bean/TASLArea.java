package edu.unito.hdmm.tasl.core.bean;

import edu.unito.hdmm.tasl.core.geo.TempArea;

public class TASLArea {

	private TASLObject taslObject;
	
	private TempArea tempArea;

	public TASLArea(TASLObject taslObject, TempArea tempArea) {
		super();
		this.taslObject = taslObject;
		this.tempArea = tempArea;
	}

	public TASLObject getTaslObject() {
		return taslObject;
	}

	public TempArea getTempArea() {
		return tempArea;
	}
	
	
	
	
	
	
	
	
}
