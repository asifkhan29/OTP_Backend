package com.otp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
@RestController
@EnableScheduling
//this api is call itself as the cloud we used (Render)  is in free accessand it automatically stop the container 
// if theres no request in 5-10 minutes now new request takes more then a minute to run  so it make sure the container always alive
public class Live {

    private final String baseUrl = "https://otp-generator-bkbr.onrender.com";

    // Controller endpoint
    @GetMapping("/api/perform-task")
    public String performTask() {
        System.out.println("Task executed at: " + java.time.LocalDateTime.now());
        return "Task executed!";
    }

    // Scheduler that runs every 2nd minute
    @Scheduled(cron = "0 */2 * * * *")
    public void callApiEveryTwoMinutes() {
        String url = baseUrl + "/api/perform-task";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            System.out.println("Scheduler called API: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error calling API: " + e.getMessage());
        }
    }
}