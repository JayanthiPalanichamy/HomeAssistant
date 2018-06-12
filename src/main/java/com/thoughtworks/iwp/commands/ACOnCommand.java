package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.AirConditioner;

public class ACOnCommand implements Command {
    private final AirConditioner airConditioner;

    public ACOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}
