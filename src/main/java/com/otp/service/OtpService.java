package com.otp.service;


import com.otp.model.ResponsOtp;

import reactor.core.publisher.Flux;

public interface OtpService {

    public Flux<ResponsOtp> generateOtp(int digits);


}
