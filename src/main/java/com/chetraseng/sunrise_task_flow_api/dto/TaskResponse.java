package com.chetraseng.sunrise_task_flow_api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private String completed;
    private LocalDateTime  createdAt;
}
