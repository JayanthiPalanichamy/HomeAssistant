public class Television {
    private boolean onStatus;

    public Television() {
        this.onStatus = false;
    }

    public boolean isOn() {
        return onStatus;
    }

    public void On(){
        onStatus = true;
    }

    public void Off(){
        onStatus = false;
    }
}
