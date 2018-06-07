public class HomeAssistant {

    private AirConditioner airConditioner;
    private Television television;

    public void addAirConditioner(AirConditioner airConditioner) {
        this.airConditioner= airConditioner;
    }

    public void doCommand(String command) {
        if("TurnOnAc".equals(command)) airConditioner.turnOn();
        else if("TurnOffAc".equals(command)) airConditioner.turnOff();
        else if("OnTv".equals(command)) television.On();
        else if("OffTv".equals(command)) television.Off();
    }

    public void addTelevision(Television television) {
        this.television = television;
    }
}
