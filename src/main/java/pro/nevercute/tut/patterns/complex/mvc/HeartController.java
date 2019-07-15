package pro.nevercute.tut.patterns.complex.mvc;

public class HeartController implements Controller {
    private HeartModel model;
    private DJView view;

    public HeartController(HeartModel model){
        this.model = model;
        this.view = new DJView(this, new HeartModelAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    @Override
    public void start() {
        
    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM(int bpm) {

    }
}
