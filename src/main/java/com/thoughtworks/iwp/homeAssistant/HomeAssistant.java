package com.thoughtworks.iwp.homeAssistant;

import com.thoughtworks.iwp.commands.Command;

import java.util.HashMap;
import java.util.Stack;

public class HomeAssistant {

    private HashMap<String, Command> deviceInstructionMap;
    private Stack<String> lastExecutedInstructionStack;

    public HomeAssistant() {
        deviceInstructionMap = new HashMap<>();
        lastExecutedInstructionStack = new Stack<>();
    }

    public void listen(String instruction) {
        if ("undo".equals(instruction)) {
            Command command = deviceInstructionMap.get(lastExecutedInstructionStack.pop());
            command.undo();
        } else {
            Command command = deviceInstructionMap.get(instruction);
            command.execute();
            lastExecutedInstructionStack.push(instruction);
        }
    }


    public void setupCommand(String instruction, Command command) {
        deviceInstructionMap.put(instruction, command);
    }

}
