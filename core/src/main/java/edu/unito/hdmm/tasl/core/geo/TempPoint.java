package edu.unito.hdmm.tasl.core.geo;


import java.sql.Timestamp;
import java.util.Date;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.operation.distance.DistanceOp;


public class TempPoint {

	
	private Point p;
	
	private Timestamp timestamp;

	
	public TempPoint(Point p, Timestamp timestamp) {
		super();
		this.p = p;
		this.timestamp = timestamp;
	}


	public Geometry getGeometry() {
		// TODO Auto-generated method stub
		return this.p;
	}
	

	

	
	 public double getDistance(TempPoint point){
		 
		 
		 DistanceOp op= new DistanceOp(this.p, point.getGeometry());
		 
		 return op.distance();
		 
	 }


	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	 
	 
	 
	
}
