package nesalmanov.ru.t1_hw1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Weather {

    String city;
    String day;
    String weather;
    int temperature;
    Date date;

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", day='" + day + '\'' +
                ", weather='" + weather + '\'' +
                ", temperature=" + temperature +
                ", date=" + date +
                '}';
    }
}
