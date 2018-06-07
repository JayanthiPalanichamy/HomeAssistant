public class Fan {
    private boolean onStatus;

    public Fan() {
        this.onStatus = false;
    }

    public void turnOn() {
        onStatus=true;
    }

    public boolean isOn() {
        return onStatus;
    }
}
