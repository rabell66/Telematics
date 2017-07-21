package com.theironyard.installparty;

import com.sun.tools.javadoc.JavaScriptScanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        VehicleInfo vehicleInfo = new VehicleInfo();
        TelematicsService telematicsService = new TelematicsService();
        vehicleInfo.setVIN(( promptForInt("Enter VIN number:")));
        vehicleInfo.setOdomenter(promptForDouble("Current Odomenter reading?"));
        vehicleInfo.setConsumption(promptForDouble("How many gallons were used?"));
        vehicleInfo.setLastOilChange(promptForDouble("Odometer reading at last oil change?"));
        vehicleInfo.setEngineSize(promptForDouble("What is the engine size in litres?"));


        telematicsService.report(vehicleInfo);


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
