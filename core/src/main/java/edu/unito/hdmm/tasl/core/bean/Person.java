package edu.unito.hdmm.tasl.core.bean;

import edu.unito.hdmm.tasl.core.geo.TempPoint;

public class Person {

	
	
	private TempPoint tempPoint;
	
	
	private TASLObject taslObject;
	
	
	private String name;
	
	private String surname;
	
	public Person(TASLObject id) {
		super();
		
		this.taslObject = id;
	}

	
	public Person( TASLObject id, TempPoint tempPoint) {
		super();
		this.taslObject = id;
		this.tempPoint = tempPoint;
	}

	
	public TempPoint getTempPoint() {
		return tempPoint;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	public TASLObject getTaslObject() {
		return taslObject;
	}


	public void setTaslObject(TASLObject taslObject) {
		this.taslObject = taslObject;
	}

	

	
   
	
	



}
