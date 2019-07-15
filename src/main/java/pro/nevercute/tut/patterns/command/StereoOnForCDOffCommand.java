package pro.nevercute.tut.patterns.command;

public class StereoOnForCDOffCommand implements Command {
    private StereoOnForCD stereoOnForCD;

    public StereoOnForCDOffCommand(StereoOnForCD stereoOnForCD){
        this.stereoOnForCD = stereoOnForCD;
    }
    @Override
    public void execute() {
        stereoOnForCD.off();
    }

    @Override
    public void undo() {
        stereoOnForCD.on();
        stereoOnForCD.setCd();
        stereoOnForCD.setVolume(11);
    }
}
