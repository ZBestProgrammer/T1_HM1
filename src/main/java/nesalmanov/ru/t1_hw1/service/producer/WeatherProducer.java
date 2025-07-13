package nesalmanov.ru.t1_hw1.service.producer;

import nesalmanov.ru.t1_hw1.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class WeatherProducer {

    private static final List<String> cities = List.of("Moscow", "Makhachkala", "Tyumen", "Magadan", "Saint Petersburg");
    private static final List<String> weather = List.of("Sunny", "Cloudy", "Rainy", "Foggy");
    private static final List<String> days = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");


    @Autowired
    private KafkaTemplate<String, List<Weather>> kafkaTemplate;

    public void send(List<Weather> message) {
        kafkaTemplate.send("weather-topic", message);
    }

    @Scheduled(fixedDelay = 5000)
    public void getWeather() {
        List<Weather> weather = generate();
        send(weather);
    }

    public List<Weather> generate() {
        List<Weather> generateWeather = new ArrayList<>();
        Random random = new Random();
        for (String city : cities) {
            for (String day : days) {
                String randomWeather = weather.get(random.nextInt(weather.size()));
                int temperature = random.nextInt(31);
                Weather w = new Weather(city, day, randomWeather, temperature, new Date(System.currentTimeMillis()));
                generateWeather.add(w);
            }
        }
        return generateWeather;
    }

}
