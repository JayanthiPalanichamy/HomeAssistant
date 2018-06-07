public class FanIncreaseSpeedCommand implements Command {
    private final Fan fan;

    public FanIncreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increaseSpeed();
    }
}
