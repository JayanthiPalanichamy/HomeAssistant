public class TvOffCommand implements Command {
    Television tv;

    public TvOffCommand(Television tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}
