package edu.unito.hdmm.tasl.core.bean;

import edu.unito.hdmm.tasl.core.geo.TempPoint;

public class Tool {

	
	private TASLObject object;
	
	private TempPoint tempPoint;

	public Tool(TASLObject object, TempPoint tempPoint) {
		super();
		this.object = object;
		this.tempPoint = tempPoint;
	}

	public TASLObject getObject() {
		return object;
	}

	public TempPoint getTempPoint() {
		return tempPoint;
	}
	
	
	
	
	
	
	
}
