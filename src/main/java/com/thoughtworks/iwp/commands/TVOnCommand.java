package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Television;

public class TVOnCommand implements Command {
    Television tv;

    public TVOnCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}
