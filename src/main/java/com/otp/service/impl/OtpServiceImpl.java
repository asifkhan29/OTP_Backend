package com.otp.service.impl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.otp.entity.Otp;
import com.otp.model.ResponsOtp;
import com.otp.repo.OtpRepository;
import com.otp.service.OtpService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
	
    private final OtpRepository otpRepository;


    @Override
    public Flux<ResponsOtp> generateOtp(int digits) {

        String otp = generateNumericOtp(digits);

        Otp entity = new Otp();
        entity.setOtp(otp);
        entity.setDigits(digits);
        entity.setCreatedAt(LocalDateTime.now());

        return otpRepository.save(entity)
                .map(saved -> {
                    ResponsOtp response = new ResponsOtp();
                    response.setOtp(saved.getOtp());
                    response.setDigits(saved.getDigits());
                    response.setCreatedAt(saved.getCreatedAt());
                    return response;
                })
                .flux();
    }

    private String generateNumericOtp(int digits) {
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        return String.valueOf(new Random().nextInt(max - min + 1) + min);
    }
}
