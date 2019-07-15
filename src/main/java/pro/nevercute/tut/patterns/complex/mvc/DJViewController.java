package pro.nevercute.tut.patterns.complex.mvc;

public class DJViewController implements Controller {
    private BeatModel model;
    private DJView view;

    public DJViewController(BeatModel model){
        this.model = model;
        view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.init();
    }

    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {
        model.setBPM(model.getBPM()+1);
    }

    @Override
    public void decreaseBPM() {
        model.setBPM(model.getBPM()-1);
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
