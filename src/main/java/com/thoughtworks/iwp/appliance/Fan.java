package com.thoughtworks.iwp.appliance;

public class Fan {
    public static final int MAX_SPEED = 5;
    public static final int MIN_SPEED = 1;
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
        if (speed < MAX_SPEED) speed++;
    }

    public int getSpeed() {
        return speed;
    }

    public void decreaseSpeed() {
        if (speed > MIN_SPEED) speed--;
    }
}
