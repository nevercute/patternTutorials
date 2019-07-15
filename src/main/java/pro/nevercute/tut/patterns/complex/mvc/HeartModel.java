package pro.nevercute.tut.patterns.complex.mvc;

public interface HeartModel {
    int getHeartRate();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void notifyBeatObservers();
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
    void notifyBPMObservers();
}
