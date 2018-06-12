package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.AirConditioner;

public class ACOffCommand implements Command {
    private final AirConditioner airConditioner;

    public ACOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }

    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}
