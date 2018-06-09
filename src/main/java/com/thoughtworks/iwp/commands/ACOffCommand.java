package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.AirConditioner;

public class ACOffCommand implements Command {
    AirConditioner airConditioner;

    public ACOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }
}
