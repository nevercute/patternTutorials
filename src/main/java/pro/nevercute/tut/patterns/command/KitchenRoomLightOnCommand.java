package pro.nevercute.tut.patterns.command;

public class KitchenRoomLightOnCommand implements Command {
    private KitchenLight kitchenLight;

    public KitchenRoomLightOnCommand(KitchenLight kitchenLight){
        this.kitchenLight = kitchenLight;
    }
    @Override
    public void execute() {
        kitchenLight.on();
    }

    @Override
    public void undo() {
        kitchenLight.off();
    }
}
