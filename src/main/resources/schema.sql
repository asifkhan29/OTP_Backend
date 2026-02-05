CREATE TABLE  otp (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    otp VARCHAR(10),
    digits INT,
    created_at TIMESTAMP
);
