public class AirConditioner {

    private boolean onStatus;

    public AirConditioner() {
        this.onStatus = false;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void turnOn(){
        onStatus = true;
    }

    public void turnOff(){
        onStatus = false;
    }
}
