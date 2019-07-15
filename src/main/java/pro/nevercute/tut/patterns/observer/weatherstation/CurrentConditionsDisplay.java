package pro.nevercute.tut.patterns.observer.weatherstation;

import java.util.Observable;

public class CurrentConditionsDisplay implements Observer, DisplayElement, java.util.Observer {
    private Float temp, humidity, pressure = Float.valueOf(0);

    @Override
    public void display() {
        System.out.printf("\nCurrent weather conditions are: " +
                "\n Temp: %.2f" +
                "\n Humidity: %.2f" +
                "\n Pressure: %.2f", temp, humidity, pressure);
    }

    @Override
    public void update(WeatherData weatherData) {
        temp = weatherData.getTemp();
        humidity = weatherData.getHumidity();
        pressure = weatherData.getPressure();
        display();
    }

    @Override
    public void update(Observable o, Object arg) {
        update((WeatherData) o);
    }
}
