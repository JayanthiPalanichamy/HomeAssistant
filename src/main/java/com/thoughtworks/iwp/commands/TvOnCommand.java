package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Television;

public class TvOnCommand implements Command {
    private final Television tv;

    public TvOnCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
