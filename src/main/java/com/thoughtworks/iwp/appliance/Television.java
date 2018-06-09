package com.thoughtworks.iwp.appliance;

public class Television {
    private boolean onStatus;

    public Television() {
        this.onStatus = false;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void on() {
        onStatus = true;
    }

    public void off() {
        onStatus = false;
    }
}
