package pro.nevercute.tut.patterns.complex.mvc;

public interface Controller {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
