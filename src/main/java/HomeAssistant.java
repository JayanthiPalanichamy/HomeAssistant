import java.util.HashMap;
import java.util.Stack;

public class HomeAssistant {

    private HashMap<String, Command> deviceInstructionMap;
    private HashMap<String,String> oppositeInstructionMap;
    private Stack<String> lastExecutedInstructionStack;

    public HomeAssistant() {
        deviceInstructionMap = new HashMap<>();
        oppositeInstructionMap = new HashMap<>();
        lastExecutedInstructionStack = new Stack<>();
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
        lastExecutedInstructionStack.push(instruction);
    }


    public void setupCommand(String instruction, Command command) {
        deviceInstructionMap.put(instruction, command);
    }

    public void undo() {
        Command command = deviceInstructionMap.get(oppositeInstructionMap.get(lastExecutedInstructionStack.pop()));
        command.execute();
    }
}
