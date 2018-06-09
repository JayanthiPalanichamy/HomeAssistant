package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Fan;

public class FanIncreaseSpeedCommand implements Command {
    private final Fan fan;

    public FanIncreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increaseSpeed();
    }

    @Override
    public void undo() {
        fan.decreaseSpeed();
    }
}
