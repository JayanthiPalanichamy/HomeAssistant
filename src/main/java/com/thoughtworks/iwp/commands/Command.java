package com.thoughtworks.iwp.commands;

public interface Command {
    void execute();
    void undo();
}
