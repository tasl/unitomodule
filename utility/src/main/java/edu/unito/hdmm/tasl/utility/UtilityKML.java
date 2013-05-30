package edu.unito.hdmm.tasl.utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import de.micromata.opengis.kml.v_2_2_0.Boundary;
import de.micromata.opengis.kml.v_2_2_0.ColorMode;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.MultiGeometry;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Polygon;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.StyleSelector;
public class UtilityKML {
	  final static String GOOGLE_CHART_API_URL = "http://chart.apis.google.com/chart?";

     

      /**
       * @param placemark change the Style of this placemark
       * @param color color format: hex value, default: white
       * @param polyMode colormode of the polygon
       * @param width width of the LineStyle, default: 0
       * @param lineColor alpha and color value in hex format, default: black
       * @param lineMode colormode of the line/border
       */
      public static void setPolyStyleAndLineStyle(Placemark placemark, String color, ColorMode polyMode, double width, String lineColor,
          ColorMode lineMode) {
              if (color == null || color.length() != 8) {
                      color = "FFFFFFFF";
                      polyMode = ColorMode.NORMAL;
              }

              if (width <= 0) {
                      width = 0;
              }
              if (lineColor == null || lineColor.length() != 8) {
                      lineColor = "FF000000";
                      lineMode = ColorMode.NORMAL;
              }
              List<StyleSelector> styleSelector = placemark.getStyleSelector();
              if (styleSelector.isEmpty()) {
                      Style style = new Style();
                      style.createAndSetPolyStyle();
                      styleSelector.add(style);
              }
              Iterator<StyleSelector> iterator = styleSelector.iterator();
              Style style = null;
              while (iterator.hasNext()) {
                      StyleSelector tmp = iterator.next();
                      if (tmp instanceof Style) {
                              style = (Style) tmp;
                              style.getPolyStyle().withColor(color).withColorMode(polyMode);
                              style.createAndSetLineStyle().withWidth(width).withColor(lineColor).withColorMode(lineMode);
                      }
              }
      }



      /**
       * set the PolyStyle of the placemark with a color the color range is a gradient from yellow to red the color calculate with the value and
       * maximum
       * 
       * @param placemark change Style of this placemark
       * @param max maximum value of the data
       * @param value current value for the placemark
       * @param width width of the line (LineStyle)
       * @param transparency alpha value for the color
       */
      
      
      
      
      public static void setDataValueColor(Placemark placemark, Double max, double value, String transparency, double width, String lineColor,
          ColorMode lineMode) {
              if (transparency == null || transparency.length() != 2) {
                      transparency = "FF";
              }
              if (lineColor == null || lineColor.length() != 8) {
                      lineColor = "FF000000"; // black
                      lineMode = ColorMode.NORMAL;
              }

              int colorValue = (int) ((value / max) * 255);
              
              
              /*
               * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
               * orange 100 % => red
               */
              String color = UtilityColor.getHexColor(0, (255 - colorValue), 255, true); // KML color format: inverse order of RGB
              setPolyStyleAndLineStyle(placemark, transparency + color, ColorMode.NORMAL, width, lineColor, lineMode);
      }


      
      public static void setDataValueColor(Placemark placemark, String color,double width, String lineColor,
              ColorMode lineMode) {
                

                  lineColor = "FF000000"; // black
                  lineMode = ColorMode.NORMAL;
                  
                  /*
                   * value <-> color conversion calculate percental value (with the max value) and use it for the hex color value 0 % => yellow 50 % =>
                   * orange 100 % => red
                   */
                  
                  setPolyStyleAndLineStyle(placemark, color, ColorMode.NORMAL, width, lineColor, lineMode);
          }
      
      
      

	
}
