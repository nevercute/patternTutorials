package pro.nevercute.tut.patterns.command;

public class CeilingHighOnCommand implements Command {
    private CeilingHigh ceilingHigh;

    public CeilingHighOnCommand(CeilingHigh ceilingHigh){
        this.ceilingHigh = ceilingHigh;
    }
    @Override
    public void execute() {
        ceilingHigh.on();
    }

    @Override
    public void undo() {
        ceilingHigh.off();
    }
}
