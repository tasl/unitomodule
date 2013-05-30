package edu.unito.hdmm.tasl.utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class UtilitySearialization {

	
	
	public static void serializeObject(Object object,File f) throws IOException{
		
        //use buffering
        OutputStream file = new FileOutputStream(f );
        OutputStream buffer = new BufferedOutputStream( file );
        ObjectOutput output = new ObjectOutputStream( buffer );
       
          output.writeObject(object);
        
        
          output.close();
        
     

	
}


public static Object deserialiseObject(File f) throws IOException, ClassNotFoundException{
	
	
	
	//use buffering
    InputStream file = new FileInputStream( f );
    InputStream buffer = new BufferedInputStream( file );
    ObjectInput input = new ObjectInputStream ( buffer );
    
      //deserialize the List
     Object object= input.readObject();
  
   
      input.close();
      
      return object;
 
}



public static List<Object> deserializeCollection(Collection<File> c) throws IOException, ClassNotFoundException{
	
	List<Object> list= Lists.newArrayList();
	
	for(File f:c){
		
		list.add(deserialiseObject(f));
		
	}
	
	return list;
	
}
	
	
	
}
