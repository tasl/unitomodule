package edu.unito.hdmm.tasl.core.bean;

public enum  TASLObjectType {

	
	    
		PERSON(1), TOOL(2), SENSOR(3), AREA(4), DPI(3);
        
        private int value;

        private TASLObjectType(int value) {
                this.value = value;
        }

		public int getValue() {
			return value;
		}

        

        
        

};

	
	
	

