package com.theironyard.installparty;

public class VehicleInfo {

    int VIN;
    double odomenter;
    double consumption;
    double lastOilChange;
    double engineSize;


    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdomenter() {
        return odomenter;
    }

    public void setOdomenter(double odomenter) {
        this.odomenter = odomenter;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
