package edu.unito.hdmm.tasl.utility;

public class UtilityColor {

	
	 /**
     * Convert three int values into a hex string
     * 
     * @param r red
     * @param g green
     * @param b blue
     * @param inserverOrder set true to use inverse order of RGB => BGR
     * @return RGB string in hex format
     */
    public static String getHexColor(int r, int g, int b, boolean inverseOrder) {
            String red, green, blue;
            String val = Integer.toHexString(r).toUpperCase();
            red = val.length() == 1 ? "0" + val : val; // add leading zero
            val = Integer.toHexString(g).toUpperCase();
            green = val.length() == 1 ? "0" + val : val; // add leading zero
            val = Integer.toHexString(b).toUpperCase();
            blue = val.length() == 1 ? "0" + val : val; // add leading zero
            if (!inverseOrder) {
                    return blue + green + red;
            } else {
                    return red + green + blue;
            }
    }
	
}
