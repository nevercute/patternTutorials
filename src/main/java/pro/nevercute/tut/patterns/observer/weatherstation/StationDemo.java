package pro.nevercute.tut.patterns.observer.weatherstation;

public class StationDemo {
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();
        Thread thread = new Thread(weatherData,"weatherThred");
        thread.start();
    }
}
