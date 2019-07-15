package pro.nevercute.tut.patterns.command;

public class SimpleRemoteControl {
    private Command slot;

    public SimpleRemoteControl(){
    }

    public SimpleRemoteControl setCommand(Command command){
        this.slot = command;
        return this;
    }

    public void buttonWasPresed(){
        slot.execute();
    }
}
