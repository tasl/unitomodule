package edu.unito.hdmm.tasl.core.bean;

public class TASLObject {

	
	
    private TASLObjectType type; 
	
	
	private int id;


	public TASLObject(TASLObjectType type, int id) {
		super();
		this.type = type;
		this.id = id;
	}


	public TASLObjectType getType() {
		return type;
	}


	public void setType(TASLObjectType type) {
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
}
