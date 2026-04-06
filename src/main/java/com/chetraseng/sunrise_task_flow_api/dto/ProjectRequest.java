package com.chetraseng.sunrise_task_flow_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProjectRequest {

  @NotBlank(message = "Name is required")
  private String name;
}