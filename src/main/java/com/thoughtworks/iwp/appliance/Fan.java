package com.thoughtworks.iwp.appliance;

public class Fan {
    private boolean onStatus;
    private int speed;

    public Fan() {
        onStatus = false;
        speed = 1;
    }

    public void turnOn() {
        onStatus = true;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void turnOff() {
        onStatus = false;
    }

    public void increaseSpeed() {
        if (speed < 5) speed++;
    }

    public int getSpeed() {
        return speed;
    }

    public void decreaseSpeed() {
        if (speed > 1) speed--;
    }
}
