package com.otp.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("otp")
public class Otp {
    @Id
	private long id;
	private String otp;
    private Integer digits;
    private LocalDateTime createdAt;

}
