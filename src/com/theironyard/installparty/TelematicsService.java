package com.theironyard.installparty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

public class TelematicsService {

   public  void report(VehicleInfo vehicleInfo) {
        // 1. Write vehicleinfo  to a file as json using VIN as file name and a JSON extension
       String json= "";
       String fileName = String.valueOf(vehicleInfo.getVIN())+".json";
       ObjectMapper mapper = new ObjectMapper();
       try {
           json = mapper.writeValueAsString(vehicleInfo);
        }  catch (JsonProcessingException e) {
           e.printStackTrace();

        }
        try{
            File file = new File(fileName);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);

        fileWriter.close();} catch (IOException e) {
            e.printStackTrace();
        }


        // 2. Find all the files that end with ".json" and convert back to a VehicleInfo object.
       File file = new File(".");
       for (File f : file.listFiles()) {
           if (f.getName().endsWith(".json")) {
               // Now you have a File object named "f". You can use this in the FileReader constructor
               // new FileReader(f)
               try {
                   FileReader fileReader = new FileReader(f);
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
           }
       }
       try {
           System.out.println(json);
           VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

       } catch (IOException e) {
           e.printStackTrace();
       }

       // 3. Update a dashboard.html


    }
}
