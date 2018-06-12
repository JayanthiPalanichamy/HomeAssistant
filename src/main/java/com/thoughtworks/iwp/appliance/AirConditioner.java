package com.thoughtworks.iwp.appliance;

public class AirConditioner {

    private boolean onStatus;

    public AirConditioner() {
        onStatus = false;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void turnOn() {
        onStatus = true;
    }

    public void turnOff() {
        onStatus = false;
    }
}
