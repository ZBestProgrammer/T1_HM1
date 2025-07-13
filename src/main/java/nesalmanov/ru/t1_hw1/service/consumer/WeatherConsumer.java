package nesalmanov.ru.t1_hw1.service.consumer;

import nesalmanov.ru.t1_hw1.entity.Weather;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class WeatherConsumer {

    @KafkaListener(topics = "weather-topic", groupId = "cons")
    public void listen(List<Weather> message) {
        for (int i = 0; i < message.size(); i++) {
            System.out.println(message.get(i));
        }
    }

}
