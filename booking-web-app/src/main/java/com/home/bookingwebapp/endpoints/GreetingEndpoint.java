package com.home.bookingwebapp.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "greeting")
public class GreetingEndpoint {

    @ReadOperation
    public String getGreeting() {
        return "There you have your message, human";
    }
}
