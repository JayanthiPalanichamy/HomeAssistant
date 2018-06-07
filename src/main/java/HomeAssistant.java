import java.util.HashMap;

public class HomeAssistant {

    HashMap<String, Command> deviceInstructionMap;
    HashMap<String,String> oppositeInstructionMap;
    private String lastExecutedInstruction;

    public HomeAssistant() {
        deviceInstructionMap = new HashMap<>();
        oppositeInstructionMap = new HashMap<>();
    }



    public void listen(String instruction) {
        Command command = deviceInstructionMap.get(instruction);
        command.execute();
        lastExecutedInstruction = instruction;
    }


    public void setupCommand(String instruction, Command command,String oppositeInstruction,Command oppositeCommand) {
        deviceInstructionMap.put(instruction, command);
        deviceInstructionMap.put(oppositeInstruction,oppositeCommand);
        oppositeInstructionMap.put(instruction,oppositeInstruction);
        oppositeInstructionMap.put(oppositeInstruction,instruction);
    }

    public void undo() {
        Command command = deviceInstructionMap.get(oppositeInstructionMap.get(lastExecutedInstruction));
        command.execute();
    }
}
