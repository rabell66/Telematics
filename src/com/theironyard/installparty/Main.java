package com.theironyard.installparty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        double consumption = tanner.nextInt();
//        double lastOilChange = tanner.nextInt();
//        double engineSize = tanner.nextInt();

        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVIN(( promptForInt("Enter VIN number:")));
        System.out.println(vehicleInfo.VIN);
//        vehicleInfo.setConsumption( promptForDouble("How much gas was used?"));
//        vehicleInfo.getEngineSize(promptForDouble("What is the engine size?"));
//        vehicleInfo.getLastOilChange(promptForDouble("Odometer reading at last oil change?"));
//        vehicleInfo.getOdomenter(promptForDouble("Current Odomenter reading?"))







    }

    private static int promptForInt(String s) {
        Scanner tanner = new Scanner(System.in);
        System.out.println(s);
        int answer = tanner.nextInt();
        return answer;

    }
}
