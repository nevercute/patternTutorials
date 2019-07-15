package pro.nevercute.tut.patterns.observer.weatherstation;

import java.util.*;

public class WeatherData extends Observable implements Subject, Runnable{
    private Float temp, pressure, humidity;
    private Scanner scanner;
    private Optional<String> data;
    private Set<Observer> observers;
    private boolean chFlag, stFlag = true;
    private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
    private WeatherStatisticsDisplay weatherStatisticsDisplay = new WeatherStatisticsDisplay();
    private String wData;
    private Random rand = new Random(1);

    public WeatherData(){
        temp = Float.valueOf(0);
        pressure = Float.valueOf(0);
        humidity = Float.valueOf(0);
        observers = new HashSet<>();
        scanner = new Scanner(System.in);
    }

    private void init() throws InterruptedException {
        while(stFlag){
            chFlag = false;
            if(scanner.hasNext()) {
                data = Optional.ofNullable(scanner.next());
            }
            if(data.isPresent()){
                System.out.println("Typed value: "+data.get()
                        + "\n data.substring(1): "+data.get().substring(1));
                wData = data.get();

                if (wData.toUpperCase().startsWith("S")) {
                    temp = rand.nextFloat();
                    humidity = rand.nextFloat();
                    pressure = rand.nextFloat();
                    System.out.println("New measurements was set");
                }
                if (wData.toUpperCase().startsWith("A")) {
                    if (wData.substring(1).toUpperCase().startsWith("W")) {
                        if(observers.add(weatherStatisticsDisplay))
                            System.out.println("WeatherStatisticsDisplay is connected");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("C")) {
                        if(observers.add(currentConditionsDisplay))
                            System.out.println("CurrentConditionsDisplay is connected");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("OW")) {
                        addObserver(weatherStatisticsDisplay);
                        System.out.println("WeatherStatisticsDisplay is connected");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("OC")) {
                        addObserver(currentConditionsDisplay);
                        System.out.println("CurrentConditionsDisplay is connected");
                    }
                }
                if (wData.toUpperCase().startsWith("D")) {
                    if (wData.substring(1).toUpperCase().startsWith("W")) {
                        if(observers.remove(weatherStatisticsDisplay))
                            System.out.println("WeatherStatisticsDisplay is deleted");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("C")) {
                        if (observers.remove(currentConditionsDisplay))
                            System.out.println("CurrentConditionsDisplay is deleted");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("OW")) {
                        deleteObserver(weatherStatisticsDisplay);
                        System.out.println("WeatherStatisticsDisplay is deleted");
                    }
                    if (wData.substring(1).toUpperCase().startsWith("OC")) {
                        deleteObserver(currentConditionsDisplay);
                        System.out.println("CurrentConditionsDisplay is deleted");
                    }
                }
            }

            if (wData.toUpperCase().startsWith("U")) {
                chFlag = true;
                setChanged();
                notifyObservers(this);
            }
            
            if(chFlag) {
                measurementsChanged();
            }

            if (wData.toUpperCase().startsWith("Q"))
                stFlag = false;
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public Float getTemp(){
        return this.temp;
    }

    public Float getPressure(){
        return this.pressure;
    }

    public Float getHumidity(){
        return this.humidity;
    }

    @Override
    public void registerObcesrver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob : observers){
            ob.update(this);
        }
    }

    @Override
    public void run() {
        try {
            init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
