package edu.unito.hdmm.tasl.core.dao;

import edu.unito.hdmm.tasl.core.bean.Person;
import edu.unito.hdmm.tasl.core.bean.Sensor;
import edu.unito.hdmm.tasl.core.bean.TASLArea;


public class DAOLocation {

	
	
	//how manage the timestamp..??
	
	public static boolean  isPersonLocatedInArea(Person p,TASLArea area ){
		
		
		
		return false;
		
	}
	
	
	
 public static boolean isSensorLocatedInArea(Person p,TASLArea area ){
		
		
		
		return false;
		
	}
	
	
 
 public static boolean isPersonCloseToSensor(Person p, Sensor s, double th){return false;}
 
 
 
 
 public static boolean inserPersonLocation(Person p){ return false;};
 
 public static boolean inserToolLocation(Person p){ return false;};
 
 
 public static boolean inserSensorLocation(Person p){ return false;};
 
 
 public static boolean inserAreaLocation(TASLArea p){ return false;};
 
 
 
 
 //contruct tthreshold 
 
 /*where st_dwithin(
		 st_transform(t1.geom,26986),st_transform(t2.geom,26986),200) ) >5
*/
 
 //point in box
 
/* SELECT * from t WHERE ST_Contains(
		 	ST_SetSRID(ST_MakeBox2D(ST_GeomFromText('POINT('|| -0.57724|| ' ' || 51.273944 ||')',4326 ),
		 	ST_GeomFromText('POINT('|| 0.29892 || ' ' || 51.744038 ||')',4326 )),4326),geom4326);
*/
 
 // select all the point in bouding box
 
 
/* 
 SELECT * 
 from t
 WHERE ST_Contains( 
      ST_SetSRID(
          ST_MakeBox2D(
             ST_Point(-0.482025, 51.300569),ST_Point(0.210114,51.691288)), 
             4326
          ), 
      geom)
*/
 
	
}
