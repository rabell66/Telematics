package com.theironyard.installparty;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelematicsService {

    public void report(VehicleInfo vehicleInfo) throws IOException {
        // 1. Write vehicleinfo  to a file as json using VIN as file name and a JSON extension
        String json = "";
        String fileName = String.valueOf(vehicleInfo.getVIN()) + ".json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(vehicleInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        try {
            File file = new File(fileName);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 2. Find all the files that end with ".json" and convert back to a VehicleInfo object.

        List<VehicleInfo> vehicleInfos = new ArrayList<>();

        File files = new File(".");
        for (File f : files.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f". You can use this in the FileReader constructor
                // new FileReader(f)
                File file = new File(f.getName());
                try (Scanner scanner = new Scanner(file)) {
                    String vehicleInfoJson = scanner.nextLine();
                    vehicleInfo = mapper.readValue(vehicleInfoJson, VehicleInfo.class);
                    vehicleInfos.add(vehicleInfo);
                } catch (JsonParseException e) {
                    System.out.println("Caught JsonParseException " + e.getMessage());
                } catch (JsonMappingException e) {
                    System.out.println("Caught JsonMappingException " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Caught IOException " + e.getMessage());
                }
            }
            double totalOdometer = 0;
            double totalConsumption = 0;
            double totalLastOilChange = 0;
            double totalEngineSize = 0;
            double totalMpg = 0;


            for (VehicleInfo vehicles : vehicleInfos) {
                totalOdometer += vehicles.getOdometer();
                totalConsumption += vehicles.getConsumption();
                totalEngineSize += Double.valueOf(vehicles.getEngineSize());
                totalLastOilChange += vehicles.getLastOilChange();
                totalMpg += vehicles.mPG();
            }

            // 3. Update a dashboard.html
            int total = vehicleInfos.size();
            String html = DashboardHtml.HTML_TOP.replace("%count%", String.valueOf(total));
            html = html.replace("%odometer%", String.format("%.1f", totalOdometer / total));
            html = html.replace("%consumption%", String.format("%.1f", totalConsumption / total));
            html = html.replace("%lastoilchange%", String.format("%.1f", totalLastOilChange / total));
            html = html.replace("%enginesize%", String.format("%.1f", totalEngineSize / total));
            html = html.replace("%mpg%", String.format("%.1f", totalMpg / total));

            StringBuilder htmlPage = new StringBuilder(html);

            // Now assemble the rows replacing the values surrounded by % with a number
            for (VehicleInfo vehicleInfo1 : vehicleInfos) {
                html =DashboardHtml.TABLE_ROW_HTML.replace("%vin%", String.valueOf(vehicleInfo1.getVIN()));
                html = html.replace("%odometer%", String.valueOf(vehicleInfo1.getOdometer()));
                html = html.replace("%consumption%", String.valueOf(vehicleInfo1.getConsumption()));
                html = html.replace("%lastoilchange%", String.valueOf(vehicleInfo1.getLastOilChange()));
                html = html.replace("%enginesize%", String.format("%.1f", Double.valueOf(vehicleInfo1.getEngineSize())));
                html = html.replace("%mpg%", String.format("%.1f", vehicleInfo1.mPG()));

                htmlPage.append(html);
            }

            htmlPage.append(DashboardHtml.HTML_FOOTER);

            // Write the dashboard.html file
            try (PrintWriter out = new PrintWriter("Dashboard.html")) {
                out.println(htmlPage.toString());
                out.flush();
            } catch (FileNotFoundException e) {
                System.out.println("Caught FileNotFoundException (could not write dashbord.html) " + e.getMessage());
            }
        }
    }




        }








