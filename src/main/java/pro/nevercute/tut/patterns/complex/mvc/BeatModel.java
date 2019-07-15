package pro.nevercute.tut.patterns.complex.mvc;

public interface BeatModel {
    void init();
    void off();
    void on();
    void setBPM(int bpm);
    int getBPM();

    void beatEvent();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void notifyBeatObservers();
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
    void notifyBPMObservers();
}
