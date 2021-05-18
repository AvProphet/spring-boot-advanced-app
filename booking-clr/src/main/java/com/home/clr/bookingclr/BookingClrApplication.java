package com.home.clr.bookingclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class BookingClrApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingClrApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner runner(RestTemplate restTemplate) throws Exception {
        return args -> {
            LOGGER.info("Starting CLR application");
            ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                    });
            rooms.getBody().forEach(room -> {
                LOGGER.info(room.toString());
            });
            LOGGER.info("Finishing CLR application");
        };
    }

//    @Bean
//    public CommandLineRunner runner2(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            LOGGER.info("Starting FizzBuzz");
//
//            for (int i = 1; i < 101; i++) {
//                if ((i % 3 == 0) && (i % 5 == 0)) {
//                    System.out.println("FizzBuzz");
//                } else if(i % 3 == 0) {
//                    System.out.println("Fizz");
//                } else if (i % 5 == 0) {
//                    System.out.println("Buzz");
//                } else {
//                    System.out.println(i);
//                }
//            }
//            LOGGER.info("Ending FizzBuzz");
//        };
//    }
//
//    @Bean
//    public CommandLineRunner run() {
//        return args -> {
//            for (int i = 1; i < 101; i++) {
//                String result = "";
//                result += (i % 3) == 0 ? "Fizz" : "";
//                result += (i % 5) == 0 ? "Buzz" : "";
//                System.out.println(!result.isEmpty() ? result : i);
//            }
//        };
//    }


    public static void main(String[] args) {
        SpringApplication.run(BookingClrApplication.class, args);
    }
}
