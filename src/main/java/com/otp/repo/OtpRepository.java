package com.otp.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.otp.entity.Otp;

public interface OtpRepository extends ReactiveCrudRepository<Otp, Long> {
}
