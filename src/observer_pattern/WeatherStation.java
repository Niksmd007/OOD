package observer_pattern;

public class WeatherStation {
    public static void main(String[] args) {
        System.out.println("Starting weather station app");
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.3f);
    }
}
