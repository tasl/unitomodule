package edu.unito.hdmm.tasl.core.geo;

import java.sql.Timestamp;
import java.util.Date;

import com.vividsolutions.jts.geom.Polygon;

public class TempArea {

	
	
	private Polygon polygon;
	
	private Timestamp timestamp;
	
	
	
	
	public TempArea(Polygon polygon, Timestamp timestamp) {
		super();
		this.polygon = polygon;
		this.timestamp = timestamp;
	}





	public Polygon getPolygon() {
		return polygon;
	}





	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	
	
	
	
	
	
}
