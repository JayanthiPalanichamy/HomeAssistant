package com.thoughtworks.iwp.commands;

import com.thoughtworks.iwp.appliance.Television;

public class TvOffCommand implements Command {
    private final Television tv;

    public TvOffCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
