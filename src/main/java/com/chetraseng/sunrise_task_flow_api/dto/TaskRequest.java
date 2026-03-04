package com.chetraseng.sunrise_task_flow_api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskRequest {
    private String title;
    private String description;

}
