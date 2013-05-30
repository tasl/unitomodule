package edu.unito.hdmm.tasl.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileExistsException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLUtility {

	
	public Document getDocumentfromFile(File xmlfile) throws ParserConfigurationException, SAXException, IOException{
	
	if (xmlfile.exists()){
		  
		  
		  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder  = factory.newDocumentBuilder();
          Document  doc = builder.parse(xmlfile);
          
          return doc;
    
	}
	
	else{
		
		 throw new FileExistsException(xmlfile);
	
	}
	
	
	
	}
	
	
	
	
	
}
