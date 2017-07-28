package com.theironyard.installparty;

import com.sun.tools.javadoc.JavaScriptScanner;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        VehicleInfo vehicleInfo = new VehicleInfo();
        TelematicsService telematicsService = new TelematicsService();
        vehicleInfo.setVIN(( promptForInt("Enter VIN number:")));
        vehicleInfo.setOdomenter(promptForDouble("Current Odomenter reading?"));
        vehicleInfo.setConsumption(promptForDouble("How many gallons were used?"));
        vehicleInfo.setLastOilChange(promptForDouble("Odometer reading at last oil change?"));
        vehicleInfo.setEngineSize(promptForDouble("What is the engine size in litres?"));


        telematicsService.report(vehicleInfo);

        System.out.printf("\t New Vehicle Added:\n Vin: %s \n Odometer: %s \n Odeometer At Last Oil Change: %s \n Engine Size: %s liters\n Gallons used: %s\n\n", vehicleInfo.VIN, vehicleInfo.getOdometer(),vehicleInfo.getLastOilChange()
                  ,vehicleInfo.getEngineSize(),vehicleInfo.getConsumption());


    }

    private static int promptForInt(String s) {
        Scanner tanner = new Scanner(System.in);
        System.out.println(s);
        int answer = tanner.nextInt();
        return answer;

    }

    private static double promptForDouble(String s){
        Scanner tanner = new Scanner(System.in);
        System.out.println(s);
        double answer = tanner.nextDouble();
        return answer;

    }

}
