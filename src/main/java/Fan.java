public class Fan {
    private boolean onStatus;
    private int speed;

    public Fan() {
        this.onStatus = false;
        this.speed = 1;
    }

    public void turnOn() {
        onStatus=true;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void turnOff() {
        onStatus = false;
    }

    public void increaseSpeed() {
        speed++;
    }

    public int getSpeed() {
        return speed;
    }
}
