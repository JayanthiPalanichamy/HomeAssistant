import java.util.HashMap;

public class HomeAssistant {

    HashMap<String, Command> deviceInstructionMap;
    HashMap<String,String> oppositeInstructionMap;
    private String lastExecutedInstruction;

    public HomeAssistant() {
        deviceInstructionMap = new HashMap<>();
        oppositeInstructionMap = new HashMap<>();
    }

    public  void setOppositeInstruction(String instruction, String oppositeInstruction) {
        if(deviceInstructionMap.containsKey(instruction) && deviceInstructionMap.containsKey(oppositeInstruction)) {
            oppositeInstructionMap.put(instruction,oppositeInstruction);
            oppositeInstructionMap.put(oppositeInstruction,instruction);
        }
        else throw new CommandNotFoundException();
    }

    public void listen(String instruction) {
        Command command = deviceInstructionMap.get(instruction);
        command.execute();
        lastExecutedInstruction = instruction;
    }


    public void setupCommand(String instruction, Command command) {
        deviceInstructionMap.put(instruction, command);
    }

    public void undo() {
        Command command = deviceInstructionMap.get(oppositeInstructionMap.get(lastExecutedInstruction));
        command.execute();
    }
}
