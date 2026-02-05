package com.otp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class ResponsOtp{
    private String otp;
    private Integer digits;
    private LocalDateTime createdAt;
}
