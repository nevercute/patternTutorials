package pro.nevercute.tut.patterns.command;

public class CeilingHighOffCommand implements Command {
    private CeilingHigh ceilingHigh;

    public CeilingHighOffCommand(CeilingHigh ceilingHigh){
        this.ceilingHigh = ceilingHigh;
    }
    @Override
    public void execute() {
        ceilingHigh.off();
    }

    @Override
    public void undo() {
        ceilingHigh.on();
    }
}
