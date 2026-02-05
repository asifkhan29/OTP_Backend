package com.otp.controller;

import com.otp.service.OtpService;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(
        origins = "*"
)
public class OtpController {

    private final OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }
    @GetMapping(value = "/generate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Map<String, Object>>> generateOtp(
            @RequestParam(defaultValue = "6") int digits) {

        return Flux.interval(Duration.ZERO, Duration.ofSeconds(30)) 
                .flatMap(tick -> otpService.generateOtp(digits))
                .map(otpEntity -> {
                    Map<String, Object> data = new HashMap<>();
                    data.put("otp", otpEntity.getOtp());
                    data.put("digits", otpEntity.getDigits());
                    data.put("createdAt", otpEntity.getCreatedAt());
                    data.put("validForSeconds", 30); // Task 2: 30s expiry

                    return ServerSentEvent.<Map<String, Object>>builder()
                            .event("otp") 
                            .data(data)
                            .build();
                });
    }
}
