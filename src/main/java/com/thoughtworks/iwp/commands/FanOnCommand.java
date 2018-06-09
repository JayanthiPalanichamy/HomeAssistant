package com.thoughtworks.iwp.commands;


import com.thoughtworks.iwp.appliance.Fan;

public class FanOnCommand implements Command {
    private final Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;

    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();

    }
}
