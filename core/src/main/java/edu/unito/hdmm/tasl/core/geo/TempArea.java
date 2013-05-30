package edu.unito.hdmm.tasl.core.geo;

import java.util.Date;

import com.vividsolutions.jts.geom.Polygon;

public class TempArea {

	
	
	private Polygon polygon;
	
	private Date timestamp;
	
	
	
	
	public TempArea(Polygon polygon, Date timestamp) {
		super();
		this.polygon = polygon;
		this.timestamp = timestamp;
	}





	public Polygon getPolygon() {
		return polygon;
	}





	public Date getTimestamp() {
		return timestamp;
	}
	
	
	
	
	
	
	
}
