package pro.nevercute.tut.patterns.command;

public class StereoOnForCDOnCommand implements Command {
    private StereoOnForCD stereoOnForCD;

    public StereoOnForCDOnCommand(StereoOnForCD stereoOnForCD){
        this.stereoOnForCD = stereoOnForCD;
    }
    @Override
    public void execute() {
        stereoOnForCD.on();
        stereoOnForCD.setCd();
        stereoOnForCD.setVolume(11);
    }

    @Override
    public void undo() {
        stereoOnForCD.off();
    }
}
