package pro.nevercute.tut.patterns.command;

public class RemoteControlSet {
    private Command onCommands[];
    private Command offCommands[];
    private Command lastCommand;
    private int slots = 7;

    public RemoteControlSet(){
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        NoCommand noCommand = new NoCommand();
        lastCommand = noCommand;
        for(int i = 0; i < onCommands.length; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public RemoteControlSet setCommand(int slot, Command onCommand, Command offCommand){
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
        return this;
    }

    public RemoteControlSet onButtonWasPressed(int slot){
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
        return this;
    }

    public RemoteControlSet offButtonWasPressed(int slot){
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
        return this;
    }

    public RemoteControlSet undoButtonWasPressed(){
        lastCommand.undo();
        return this;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < onCommands.length; i++){
            sb.append("\nSlot: "+i+". Commands: "+onCommands[i].getClass().getSimpleName() + ", "+offCommands[i].getClass().getSimpleName());
        }
        return sb.toString();
    }
}
