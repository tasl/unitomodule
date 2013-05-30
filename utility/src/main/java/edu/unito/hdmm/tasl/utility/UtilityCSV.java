package edu.unito.hdmm.tasl.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class UtilityCSV {

    /**
     * Read a CSV file and put each line into the list. Each item have a arrays of strings (for each column)
     * 
     * @param fileWithPath path to the CSV file
     * @param delimiter , usually comma
     * @return list of arrays and array of strings
     */
    public static List<String[]> loadCsvFile(String fileWithPath, String delimiter) {
            // read CSV file
            Vector<String[]> list = new Vector<String[]>();
            if (delimiter == null || delimiter.equals("")) {
                    delimiter = ",";
            }
            BufferedReader reader = null;
            String readString;
            try {
                    // open file
                    reader = new BufferedReader(new FileReader(new File(fileWithPath)));
                    while ((readString = reader.readLine()) != null) {
                            list.add(readString.split(delimiter));
                    }
                    reader.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return list;
    }

    /**
     * Convert the data of a CVS file into a Hashmap hashmap keys => codeColumn hashmap values => dataColumn Example: hashmap.get("AFG")
     * returns the data of Afghanistan
     * 
     * @param fileWithPath path to the CSV file
     * @param codeColumn index of the column for the area or country code
     * @param dataColumn index of the column for the data (double value)
     * @return Hashmap filled with data from the CSV
     */
    public static HashMap<String, Double> readCSVDoubleData(String fileWithPath, int codeColumn, int dataColumn) {

            List<String[]> stringVector = loadCsvFile(fileWithPath, ",\"");
            int size = stringVector.size(); // size of rows in the CSV file
            HashMap<String, Double> dataMap = new HashMap<String, Double>();
            double max = Double.NEGATIVE_INFINITY;
            double min = Double.POSITIVE_INFINITY;
            String regex = "\"";
            String replacement = "";
            String code, data;

            // ignore header, start with index 1
            for (int i = 1; i < size; i++) {
                    String[] row = stringVector.get(i); // get row with index i: array of strings (for each column)
                    code = row[codeColumn].replaceAll(regex, replacement).trim();
                    data = row[dataColumn].replaceAll(regex, replacement).trim();
                    // save minimum and maximum
                    max = Math.max(new Double(data), max);
                    min = Math.min(new Double(data), min);
                    dataMap.put(code, new Double(data));
            }
            // save min and max to HashMap
            dataMap.put("minimum", min);
            dataMap.put("maximum", max);
            return dataMap;
    }

    /**
     * Convert the data of a CVS file into a nested Hashmap hashmap keys => codeColumn hashmap values => nested Hashmap nested keys => =>
     * multiColumn nested values => dataColumn Example: hashmap.get("AFG").get("2009") returns the data of Afghanistan in year 2009
     * 
     * @param fileWithPath path to the CSV file
     * @param codeColumn index of the column for the area or country code
     * @param dataColumn index of the column for the data (double value)
     * @param multiColumn index of the column for the year
     * @return Hashmap filled with data from the CSV
     * 
     *         Hashmap contains keys from the dataColum, values as (nested Hashmap) nested Hashmap contains keys from the multiColumn and
     *         values from the dataColumn
     */
    public static HashMap<String, HashMap<String, Double>> readMultiDataFromCVS(String fileWithPath, int codeColumn, int dataColumn,
        int multiColumn) {

            // read CSV file
            List<String[]> stringVector = loadCsvFile(fileWithPath, ",\"");
            int size = stringVector.size(); // size of rows in the CSV file
            HashMap<String, HashMap<String, Double>> dataMap = new HashMap<String, HashMap<String, Double>>();
            double max = Double.NEGATIVE_INFINITY;
            double min = Double.POSITIVE_INFINITY;
            String regex = "\"";
            String replacement = "";
            String code, data, multiData;

            // ignore header, start with index 1
            for (int i = 1; i < size; i++) {
                    String[] row = stringVector.get(i); // get row with index i: array of strings (for each column)
                    code = row[codeColumn].replaceAll(regex, replacement).trim();
                    data = row[dataColumn].replaceAll(regex, replacement).trim();
                    multiData = row[multiColumn].replaceAll(regex, replacement).trim();

                    if (!dataMap.containsKey(code)) {
                            HashMap<String, Double> tmp = new HashMap<String, Double>();
                            dataMap.put(code, tmp);
                    }
                    HashMap<String, Double> nested = dataMap.get(code);
                    double value = new Double(data);
                    nested.put(multiData, new Double(value));

                    // save minimum and maximum
                    max = Math.max(value, max);
                    min = Math.min(value, min);
            }

            // save min and max to HashMap
            HashMap<String, Double> minmax = new HashMap<String, Double>();
            minmax.put("minimum", min);
            minmax.put("maximum", max);
            dataMap.put("info", minmax);
            return dataMap;
    }

}
