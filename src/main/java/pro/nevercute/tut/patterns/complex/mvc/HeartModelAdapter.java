package pro.nevercute.tut.patterns.complex.mvc;

public class HeartModelAdapter implements BeatModel {
    HeartModel heartModel;

    public HeartModelAdapter(HeartModel heartModel){
        this.heartModel = heartModel;
    }

    @Override
    public void init() {

    }

    @Override
    public void off() {

    }

    @Override
    public void on() {

    }

    @Override
    public void setBPM(int bpm) {

    }

    @Override
    public int getBPM() {
        return heartModel.getHeartRate();
    }

    @Override
    public void beatEvent() {

    }

    @Override
    public void registerObserver(BeatObserver o) {
        heartModel.registerObserver(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        heartModel.removeObserver(o);
    }

    @Override
    public void notifyBeatObservers() {
        heartModel.notifyBeatObservers();
    }

    @Override
    public void registerObserver(BPMObserver o) {
        heartModel.registerObserver(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        heartModel.removeObserver(o);
    }

    @Override
    public void notifyBPMObservers() {
        heartModel.notifyBPMObservers();
    }

    }
