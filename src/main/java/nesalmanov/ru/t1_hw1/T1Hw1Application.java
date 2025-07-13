package nesalmanov.ru.t1_hw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class T1Hw1Application {

    public static void main(String[] args) {
        SpringApplication.run(T1Hw1Application.class, args);
    }

}
