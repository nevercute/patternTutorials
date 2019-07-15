package pro.nevercute.tut.patterns.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        Command onCommand[] = {new StereoOnForCDOnCommand(new StereoOnForCD()), new LivingRoomLightOnCommand(new LivingRoomLight())};
        Command offCommand[] = {new StereoOnForCDOffCommand(new StereoOnForCD()), new LivingRoomLightOffCommand(new LivingRoomLight())};

        MacroCommand onMacro = new MacroCommand(onCommand);
        MacroCommand offMacro = new MacroCommand(offCommand);

        RemoteControlSet remote = new RemoteControlSet();
        remote.setCommand(0, onMacro, offMacro);

        remote.onButtonWasPressed(0).offButtonWasPressed(0).undoButtonWasPressed();
        System.out.println(remote);
    }
}
