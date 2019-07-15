package pro.nevercute.tut.patterns.command;

public class LivingRoomLightOffCommand implements Command {
    private LivingRoomLight livingRoomLight;

    public LivingRoomLightOffCommand(LivingRoomLight livingRoomLight){
        this.livingRoomLight = livingRoomLight;
    }
    @Override
    public void execute() {
        livingRoomLight.off();
    }

    @Override
    public void undo() {
        livingRoomLight.on();
    }
}
