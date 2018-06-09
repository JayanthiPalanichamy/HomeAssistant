package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Fan;

public class FanOffCommand implements Command {
    private final Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }
}
