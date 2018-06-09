package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Fan;

public class FanDecreaseSpeedCommand implements Command {
    private final Fan fan;

    public FanDecreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.decreaseSpeed();
    }
}
