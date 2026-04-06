package com.chetraseng.sunrise_task_flow_api.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class AuthResponse {
    private String token;
    private String refreshToken;
    private long expiresIn;
    private String email;
    private String role;
}