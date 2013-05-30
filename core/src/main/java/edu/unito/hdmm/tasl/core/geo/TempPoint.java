package edu.unito.hdmm.tasl.core.geo;


import java.util.Date;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.operation.distance.DistanceOp;


public class TempPoint {

	
	private Point p;
	
	private Date timestamp;

	
	public TempPoint(Point p, Date timestamp) {
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


	public Date getTimestamp() {
		return timestamp;
	}
	
	 
	 
	 
	
}
