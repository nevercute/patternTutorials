package pro.nevercute.tut.patterns.complex.mvc;

public class MVCTest {
    public static void main(String[] args) {
        BeatModel model = new BeatModelImpl();
        HeartModel heartModel = new HeartModelImpl();
        Controller controller = new HeartController(heartModel); //new DJViewController(model);
    }
}
