package pro.nevercute.tut.patterns.command;

public class KitchenRoomLightOffCommand implements Command {
    private KitchenLight kitchenLight;

    public KitchenRoomLightOffCommand(KitchenLight kitchenLight){
        this.kitchenLight = kitchenLight;
    }
    @Override
    public void execute() {
        kitchenLight.off();
    }

    @Override
    public void undo() {
        kitchenLight.on();
    }
}
