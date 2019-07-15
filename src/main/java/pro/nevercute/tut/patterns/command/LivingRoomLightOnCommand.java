package pro.nevercute.tut.patterns.command;

public class LivingRoomLightOnCommand implements Command {
    private LivingRoomLight livingRoomLight;

    public LivingRoomLightOnCommand(LivingRoomLight livingRoomLight){
        this.livingRoomLight = livingRoomLight;
    }
    @Override
    public void execute() {
        livingRoomLight.on();
    }

    @Override
    public void undo() {
        livingRoomLight.off();
    }
}
