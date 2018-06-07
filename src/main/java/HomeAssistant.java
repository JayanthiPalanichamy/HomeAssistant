import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeAssistant {

    HashMap<String , Command> deviceInstructionMap;

    public HomeAssistant() {
        deviceInstructionMap = new HashMap<>();
    }

    public void listen(String instruction) {
        Command command = deviceInstructionMap.get(instruction);
        command.execute();

    }


    public void addCommand(String instruction,Command command) {
        deviceInstructionMap.put(instruction,command);
    }
}
