package edu.unito.hdmm.tasl.utility;

import java.sql.Array;
import java.sql.SQLException;

public class UtilityText {

	
	
		
		
		
		 public static String processTextSqlArray(Array array,String concat) throws SQLException{
			 
			 String [] arrayText=(String[])array.getArray();
			 
			 String text="";
			 
			 for(String u: arrayText){
				 
				 text=text+concat+u;
				 
				 
			 }
			 
			 
			 return text;
			 
		 }
		
		
		
	

}
