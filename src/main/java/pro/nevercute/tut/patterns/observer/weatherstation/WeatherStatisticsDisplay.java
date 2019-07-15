package pro.nevercute.tut.patterns.observer.weatherstation;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.OptionalDouble;

public class WeatherStatisticsDisplay implements Observer, DisplayElement, java.util.Observer {
    private List<Float> temp = new LinkedList<>();
    private List<Float> humidity = new LinkedList<>();
    private List<Float> pressure = new LinkedList<>();
    private OptionalDouble oTemp, oHumidity, oPressure;
    
    @Override
    public void display() {
        System.out.printf("\n\nWeather average statistics are: " +
                "\n Temp: %s" +
                "\n Humidity: %s" +
                "\n Pressure: %s"
                , oTemp.isPresent() ? oTemp.getAsDouble() : "0.0"
                , oHumidity.isPresent() ? oHumidity.getAsDouble() : "0.0"
                , oPressure.isPresent() ? oPressure.getAsDouble() : "0.0"
        );
    }

    @Override
    public void update(WeatherData weatherData) {
        if(temp.add(weatherData.getTemp()) || humidity.add(weatherData.getHumidity()) || pressure.add(weatherData.getPressure()))
        {
            oTemp = temp.stream().mapToDouble( a -> a).average();
            oHumidity = humidity.stream().mapToDouble( a -> a).average();
            oPressure = pressure.stream().mapToDouble( a -> a).average();
        }
        display();
    }

    @Override
    public void update(Observable o, Object arg) {
        update((WeatherData) o);
    }
}
