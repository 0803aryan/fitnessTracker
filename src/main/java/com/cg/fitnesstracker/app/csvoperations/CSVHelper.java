package com.cg.fitnesstracker.app.csvoperations;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.cg.fitnesstracker.app.model.FoodItem;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "foodName", "foodQuantity", "caloriesInFood"};

   public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
        	
            return true;
        }

       return false;
    }

   public static List<FoodItem> csvToFoodItem(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                @SuppressWarnings("deprecation")
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
        
           List<FoodItem> foodList = new ArrayList<>();

           Iterable<CSVRecord> csvRecords = csvParser.getRecords();

           for (CSVRecord csvRecord : csvRecords) {
                FoodItem items = new FoodItem(
                        csvRecord.get("foodName"),
                        csvRecord.get("foodQuantity"),
                        Integer.parseInt(csvRecord.get("caloriesInFood"))
                        );

               foodList.add(items);
            }

           return foodList;

       } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
        
}